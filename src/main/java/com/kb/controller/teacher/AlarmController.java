package com.kb.controller.teacher;

import com.kb.alarm.service.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/alarm")
public class AlarmController {

    private final AlarmService alarmService;

    @GetMapping("/subscribe/")
    public SseEmitter subscribe(Authentication authentication) {
        SseEmitter emitter = new SseEmitter();
        authentication.getPrincipal();
        alarmService.addEmitter(, emitter);
        return emitter;
    }

    @PostMapping("/send/{userId}")
    public ResponseEntity<String> sendNotification(@PathVariable Long userId, @RequestBody String message) {
        alarmService.sendNotification(userId, message);
        return ResponseEntity.ok("Notification sent");
    }
}
