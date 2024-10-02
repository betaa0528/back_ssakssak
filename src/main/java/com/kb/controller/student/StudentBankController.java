package com.kb.controller.student;

import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingDTO;
import com.kb.saving.service.SavingService;
import com.kb.savingAccount.dto.SavingAccountDTO;
import com.kb.savingAccount.service.SavingAccountService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/bank")
@RequiredArgsConstructor
@Slf4j
@Api(value= "StudentBankController", tags = "학생 dmsgod 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentBankController {

    private final SavingService SavingService;
    private final SavingAccountService SavingAccountService;

    @GetMapping("/products-list")
    public ResponseEntity<List<SavingDTO>> getSavingProduct() {
        List<SavingDTO> SavingList = SavingService.getSavingProduct();

        return ResponseEntity.ok(SavingList);
    }


    @GetMapping("/mylist/{studentId}")
    public ResponseEntity<List<SavingAccountDTO>> getMySavingAccounts(@PathVariable Long studentId) {
        List<SavingAccountDTO> savingAccountList = SavingAccountService.getSavingAccountsByStudentId(studentId);
        return ResponseEntity.ok(savingAccountList);
    }


    @PostMapping("/product/{id}")
    public ResponseEntity<SavingAccountDTO> createSavingAccount(@RequestBody SavingAccountDTO savingAccountDTO) {
        SavingAccountDTO createdSavingAccount = SavingAccountService.createSavingAccount(savingAccountDTO);

        return new ResponseEntity<>(createdSavingAccount, HttpStatus.CREATED);
    }


}