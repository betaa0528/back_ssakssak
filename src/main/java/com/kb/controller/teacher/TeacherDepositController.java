package com.kb.controller.teacher;

import com.kb.deposit.dto.DepositDTO;
import com.kb.deposit.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/bank")
@RequiredArgsConstructor
public class TeacherDepositController {

    private final DepositService depositService;

    @GetMapping("/deposit-list")
    public ResponseEntity<List<DepositDTO>> getDepositList() {
        List<DepositDTO> depositList = depositService.getDepositList();
        return ResponseEntity.ok(depositList);
    }
}