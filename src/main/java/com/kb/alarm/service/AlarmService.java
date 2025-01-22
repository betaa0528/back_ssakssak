package com.kb.alarm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kb.alarm.dto.*;
import com.kb.alarm.mapper.AlarmMapper;
import com.kb.coupon.mapper.CouponMapper;
import com.kb.emitter.EmitterRepository;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import com.kb.teacher.dto.TeacherDTO;
import com.kb.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Log4j
@Service
public class AlarmService {

    private static final String ALARM_NAME = "alarm";

    private final EmitterRepository emitterRepository;
    private final AlarmMapper alarmMapper;
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final CouponMapper couponMapper;

    public SseEmitter addEmitter(String username) throws IOException {
        SseEmitter sseEmitter = new SseEmitter(DEFAULT_TIMEOUT);
        emitterRepository.save(username, sseEmitter);
        sseEmitter.onCompletion(() -> emitterRepository.delete(username));
        sseEmitter.onTimeout(() -> emitterRepository.delete(username));

        try {
            log.info("alarm subscribe check");
            sseEmitter.send(SseEmitter.event()
                    .name(ALARM_NAME)
                    .data("connect alarm"));
        } catch (IOException e) {
            log.error("alarm sent error : {}", e);
            throw new IOException(e.getMessage());
        }
        return sseEmitter;
    }

    private Alarm createAlarm(Long userId, AlarmType alarmType, Long productId) {
        Alarm alarm = new Alarm();
        Student student = studentMapper.selectStudentById(userId);
        String targetTchName = teacherMapper.selectTchNameByTchId(student.getTchId());
        alarm.setStudent(student);
        alarm.setType(alarmType.toString());
        alarm.setTargetUserName(targetTchName);
        alarm.setProductId(productId);
        alarm.setSent('n');

        return alarm;
    }

    public void sendAlarm(Long userId, AlarmArgs args, Long productId) {
        Alarm alarm = createAlarm(userId, args.getAlarmType(), productId);
        alarm.setSent('y');

        AlarmRequest request = new AlarmRequest(productId, args.getAlarmType().createMessage(args));


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "event-stream", StandardCharsets.UTF_8));

        alarmMapper.insertAlarm(alarm);
        ObjectMapper om = new ObjectMapper();
        SseEmitter sseEmitter = emitterRepository.get(alarm.getTargetUserName());
        try {
            String alarmJson = om.writeValueAsString(request);
            log.info("alarm sent check");
            sseEmitter.send(SseEmitter.event()
                    .name(ALARM_NAME)
                    .data(alarmJson, MediaType.TEXT_EVENT_STREAM));
        } catch (IOException e) {
            log.error("alarm sent error : {}", e);
            emitterRepository.delete(alarm.getTargetUserName());
            throw new RuntimeException(e);
        }

    }

    public List<AlarmResponse> getAlarmByTeacherProfile(String username) {
        TeacherDTO teacherDTO = teacherMapper.selectByTeacherProfile(username);
        List<Alarm> alarmList = alarmMapper.selectAllAlarmListByTeacherId(teacherDTO.getTchId());


        return alarmList.stream()
                .map(alarm -> {
                    AlarmType alarmType = AlarmType.valueOf(alarm.getType());
                    String productName = selectProductName(alarmType, alarm.getProductId());
                    AlarmArgs alarmArgs = new AlarmArgs(alarmType, productName, alarm.getStudent().getStdName());
                    return new AlarmResponse(alarm.getId(), alarm.getType(), alarmArgs.getAlarmType().createMessage(alarmArgs));
                })
                .collect(Collectors.toList());
    }

    public void changeIsChecked(long id) {
        int result = alarmMapper.updateAlarmIsChecked(id);
        if (result != 1) {
            throw new NoSuchElementException("update Failed");
        }
    }

    private String selectProductName(AlarmType type, long productId) {
        switch (type) {
            case COUPON_BUY -> {
                return couponMapper.selectCouponById(productId).getCpName();
            }
            default -> {
                return "";
            }
        }
    }

}
