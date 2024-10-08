package com.kb.controller.teacher;

import com.kb.alarm.dto.Alarm;
import com.kb.alarm.dto.AlarmRequest;
import com.kb.alarm.dto.AlarmResponse;
import com.kb.alarm.dto.AlarmType;
import com.kb.alarm.service.AlarmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/alarm")
public class AlarmController {

    private final AlarmService alarmService;

    @GetMapping("/subscribe/{userId}")
    public SseEmitter subscribe(@PathVariable("userId") long tchId) throws IOException {
        log.info("subscribe");
        return alarmService.addEmitter(tchId);
    }

//    @PostMapping("/send/{userId}")
//    public ResponseEntity<String> sendNotification(@PathVariable Long userId, @RequestBody AlarmRequest request) {
//        log.info("subscribe");
//        String message = request.getMessage();
//        AlarmType alarmType = request.getAlarmType();
//        alarmService.sendAlarm(userId, message, alarmType);
//        return ResponseEntity.ok("");
//    }

    @GetMapping("/history")
    public ResponseEntity<List<AlarmResponse>> getAlarmHistory(@RequestParam String username) {
        List<AlarmResponse> alarmList = alarmService.getAlarmByTeacherProfile(username);
        return ResponseEntity.ok(alarmList);
    }

    @PostMapping("/checked/{id}")
    public ResponseEntity<String> updateAlarmIsChecked(@PathVariable long id) {
        alarmService.changeIsChecked(id);
        return ResponseEntity.ok("Alarm check success");
    }
}
