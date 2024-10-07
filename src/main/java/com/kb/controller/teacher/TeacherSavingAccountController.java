package com.kb.controller.teacher;

import com.kb.savingAccount.dto.SavingAccountDTO;
import com.kb.savingAccount.service.SavingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher/bank")
@RequiredArgsConstructor
public class TeacherSavingAccountController {

    private final SavingAccountService savingAccountService;

    @PostMapping("/saving-apply")
    public ResponseEntity<String> applySaving(@RequestBody SavingAccountDTO savingAccountDTO) {
        savingAccountService.createSavingAccount(savingAccountDTO);
        return ResponseEntity.ok("successfully!");
    }
}