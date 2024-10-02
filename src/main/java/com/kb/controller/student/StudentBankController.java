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
@Api(value= "StudentSavingController", tags = "학생 주식 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentBankController {

    private final SavingService SavingService;
    private final SavingAccountService SavingAccountService;

    //금융 삼품 출력
    @GetMapping("/products-list")
    public ResponseEntity<List<SavingDTO>> getSavingProduct() {
        List<SavingDTO> SavingList = SavingService.getSavingProduct();

        return ResponseEntity.ok(SavingList);
    }


    @GetMapping("/account/list")
    public ResponseEntity<List<SavingAccountDTO>> getSavingAccount() {
        List<SavingAccountDTO> SavingAccountList = SavingAccountService.getSavingAccount();
        return ResponseEntity.ok(SavingAccountList);
    }


    // stdID에 따른 학생이 가진 적금내역 출력
    @GetMapping("/mylist/{studentId}")
    public ResponseEntity<List<SavingAccountDTO>> getMySavingAccounts(@PathVariable Long studentId) {
        List<SavingAccountDTO> savingAccountList = SavingAccountService.getSavingAccountsByStudentId(studentId);
        return ResponseEntity.ok(savingAccountList);
    }


//    적금 가입 정보 전송
    @PostMapping("/product/{id}")
    public ResponseEntity<SavingAccountDTO> createSavingAccount(@RequestBody SavingAccountDTO savingAccountDTO) {
        // SavingAccountService를 통해 적금 상품 가입 처리
        SavingAccountDTO createdSavingAccount = SavingAccountService.createSavingAccount(savingAccountDTO);

        // 성공적으로 생성되면 201(Created) 상태 반환
        return new ResponseEntity<>(createdSavingAccount, HttpStatus.CREATED);
    }


}