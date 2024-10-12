package com.kb.alarm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kb.alarm.dto.*;
import com.kb.alarm.mapper.AlarmMapper;
import com.kb.coupon.mapper.CouponMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import com.kb.teacher.dto.TeacherDTO;
import com.kb.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j
@Service
public class AlarmService {

    private static final String ALARM_NAME = "alarm";

    private final Map<String, List<SseEmitter>> emitters = new ConcurrentHashMap<>();
    private final AlarmMapper alarmMapper;
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final CouponMapper couponMapper;

    public SseEmitter addEmitter(String username) throws IOException {
        SseEmitter sseEmitter = new SseEmitter(0L);
        emitters.computeIfAbsent(username, k -> new ArrayList<>()).add(sseEmitter);
        sseEmitter.onCompletion(() -> emitters.get(username).remove(sseEmitter));
        sseEmitter.onTimeout(() -> emitters.get(username).remove(sseEmitter));

        return sseEmitter;
    }

    public void sendAlarm(Long userId, String message, AlarmType type, Long productId) {
        Alarm alarm = new Alarm();
        Student student = studentMapper.selectStudentById(userId);
        alarm.setStudent(student);
        alarm.setType(type.toString());
        alarm.setTargetId(student.getStdId());
        alarm.setProductId(productId);
        alarmMapper.insertAlarm(alarm);

        AlarmRequest request = new AlarmRequest(productId, message);

        List<SseEmitter> userEmitters = emitters.get(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "event-stream", StandardCharsets.UTF_8));

        ObjectMapper om = new ObjectMapper();
        if (userEmitters != null) {
            for(SseEmitter emitter : userEmitters) {
                try {
                    String alarmJson = om.writeValueAsString(request);
                    emitter.send(SseEmitter.event()
                            .name(ALARM_NAME)
                            .data(alarmJson, MediaType.TEXT_EVENT_STREAM));
                } catch (IOException e) {
                    emitter.completeWithError(e);
                }
            }
        }
    }

    public List<AlarmResponse> getAlarmByTeacherProfile(String username) {
        TeacherDTO teacherDTO = teacherMapper.selectByTeacherProfile(username);
        List<Alarm> alarmList = alarmMapper.selectAllAlarmListByTeacherId(teacherDTO.getTchId());



        return alarmList.stream()
                .map(alarm -> {
                    AlarmType alarmType = AlarmType.valueOf(alarm.getType());
                    String productName = selectProductName(alarmType, alarm.getProductId());
                    AlarmArgsImpl alarmArgs = new AlarmArgsImpl(alarmType, productName);
                    String alarmMsg = alarmType.createMessage(alarmArgs);
                    StringBuilder sb = new StringBuilder(alarm.getStudent().getStdName()).append(alarmMsg);
                    return new AlarmResponse(alarm.getId(), alarm.getType(), sb.toString());
                })
                .collect(Collectors.toList());
    }

    public void changeIsChecked(long id) {
        int result = alarmMapper.updateAlarmIsChecked(id);
        if(result != 1) {
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
