package com.kb.controller.student;

import com.kb.depositAccount.domain.DepositAccount;
import com.kb.depositAccount.dto.DepositAccountDTO;
import com.kb.depositAccount.dto.DepositAccountResponse;
import com.kb.depositAccount.service.DepositAccountService;
import com.kb.member.dto.Member;
import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingDTO;
import com.kb.saving.service.SavingService;
import com.kb.savingAccount.dto.SavingAccountDTO;
import com.kb.savingAccount.service.SavingAccountService;
import com.kb.student.dto.SeedRankingDTO;
import com.kb.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/bank")
@RequiredArgsConstructor
@Slf4j
@Api(value= "StudentBankController", tags = "학생 은행 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentBankController {

    private final SavingService SavingService;
    private final SavingAccountService SavingAccountService;
    private final StudentService studentService;
    private final DepositAccountService depositAccountService;
    private final SavingAccountService savingAccountService;

    @GetMapping("/products-list")
    public ResponseEntity<List<SavingDTO>> getSavingProduct() {
        List<SavingDTO> SavingList = SavingService.getSavingProduct();

        return ResponseEntity.ok(SavingList);
    }

    @GetMapping("/deposit-account")
    public ResponseEntity<List<DepositAccountResponse>> getDepositAccount(@AuthenticationPrincipal Member member) {
        List<DepositAccountResponse> depositAccountById = depositAccountService.getDepositAccountById(member);
        return ResponseEntity.ok(depositAccountById);
    }

    @PostMapping("/deposit-account")
    public ResponseEntity<String> addDepositAccount(@RequestBody DepositAccountDTO depositAccountDTO , @AuthenticationPrincipal Member member) {
        depositAccountService.subscribeDepositAccount(depositAccountDTO, member);
        return ResponseEntity.ok("예금에 가입에 성공했습니다.");
    }

    @GetMapping("/saving-account")
    public ResponseEntity<List<SavingAccountDTO>> getMySavingAccounts(@AuthenticationPrincipal Member member) {
        List<SavingAccountDTO> savingAccountList = SavingAccountService.getSavingAccountsByStudentId(member);
        return ResponseEntity.ok(savingAccountList);
    }


    @PostMapping("/product")
    public ResponseEntity<SavingAccountDTO> createSavingAccount(@RequestBody SavingAccountDTO savingAccountDTO, @AuthenticationPrincipal Member member) {
        SavingAccountDTO createdSavingAccount = SavingAccountService.createSavingAccount(savingAccountDTO, member);

        return new ResponseEntity<>(createdSavingAccount, HttpStatus.CREATED);
    }


    @GetMapping("/seed-ranking")
    public ResponseEntity<List<SeedRankingDTO>> getSeedRanking() {
        List<SeedRankingDTO> ranking = studentService.getSeedRanking();
        return ResponseEntity.ok(ranking);
    }

    @PostMapping("/deposit/cancel/{id}")
    public ResponseEntity<String> cancelDepositAccount(@PathVariable long id) {
        depositAccountService.cancelDepositAccount(id);
        return ResponseEntity.ok("예금을 해지 했습니다.");
    }

    @PostMapping("/saving/cancel/{id}")
    public ResponseEntity<String> cancelSavingAccount(@PathVariable long id) {
        savingAccountService.cancelSavingAccount(id);
        return ResponseEntity.ok("적금을 해지 했습니다.");
    }

}