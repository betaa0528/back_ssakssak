package com.kb.alarm.service;

import com.kb.alarm.dto.Alarm;
import com.kb.alarm.dto.TeacherProfile;
import com.kb.alarm.mapper.AlarmMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import com.kb.teacher.dto.TeacherDTO;
import com.kb.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Log4j
@Service
public class AlarmService {

    private static final String ALARM_NAME = "alarm";

    private final Map<Long, List<SseEmitter>> emitters = new ConcurrentHashMap<>();
    private final AlarmMapper alarmMapper;
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;

    public SseEmitter addEmitter(long tchId) throws IOException {
        SseEmitter sseEmitter = new SseEmitter(DEFAULT_TIMEOUT);
        emitters.computeIfAbsent(tchId, k -> new ArrayList<>()).add(sseEmitter);
        sseEmitter.onCompletion(() -> emitters.get(tchId).remove(sseEmitter));
        sseEmitter.onTimeout(() -> emitters.get(tchId).remove(sseEmitter));

        try {
            log.info("send");
            sseEmitter.send(SseEmitter.event()
                    .id("id")
                    .name(ALARM_NAME)
                    .data("connect completed"));
        } catch (IOException e) {
            throw new IOException("알람 연결 에러입니다.");
        }
        return sseEmitter;
    }

    public void sendAlarm(Long userId, String message) {
        Alarm alarm = new Alarm();
        Student student = studentMapper.selectStudentById(userId);
        alarm.setStudent(student);
        alarm.setType(message);
        alarm.setTargetId(student.getStdId());
        alarmMapper.insertAlarm(alarm);

        List<SseEmitter> userEmitters = emitters.get(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "event-stream", StandardCharsets.UTF_8));
        if (userEmitters != null) {
            for(SseEmitter emitter : userEmitters) {
                try {
                    emitter.send(SseEmitter.event()
                            .name(ALARM_NAME)
                            .data(message, MediaType.TEXT_EVENT_STREAM));
                } catch (IOException e) {
                    emitter.completeWithError(e);
                }
            }
        }
    }

    public List<Alarm> getAlarmByTeacherProfile(String username) {
        TeacherDTO teacherDTO = teacherMapper.selectByTeacherProfile(username);
        return alarmMapper.selectAllAlarmListByTeacherId(teacherDTO.getTchId());
    }

    public void changeIsChecked(long id) {
        int result = alarmMapper.updateAlarmIsChecked(id);
        if(result != 1) {
            throw new NoSuchElementException("update Failed");
        }
    }
}
