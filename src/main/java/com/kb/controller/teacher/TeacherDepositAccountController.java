package com.kb.controller.teacher;

import com.kb.depositAccount.dto.DepositAccountDTO;
import com.kb.depositAccount.service.DepositAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher/bank")
@RequiredArgsConstructor
public class TeacherDepositAccountController {

    private final DepositAccountService depositAccountService;

    @PostMapping("/deposit-apply")
    public ResponseEntity<String> applySaving(@RequestBody DepositAccountDTO depositAccountDTO) {
        depositAccountService.saveDeposit(depositAccountDTO);
        return ResponseEntity.ok("Deposit account registered successfully!");
    }
}