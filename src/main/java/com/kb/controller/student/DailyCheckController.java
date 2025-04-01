package com.kb.controller.student;

import com.kb.dailyCheck.dto.DailyCheckDTO;
import com.kb.dailyCheck.service.DailyCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/profile")
@RequiredArgsConstructor
public class DailyCheckController {

    private final DailyCheckService dailyCheckService;

    @PostMapping("/daily-check")
    public ResponseEntity<String> insertDailyCheck(@RequestBody DailyCheckDTO dailyCheckDTO) {
        dailyCheckService.insertDailyCheck(dailyCheckDTO);
        return ResponseEntity.ok("DailyCheck successfully!");
    }
}