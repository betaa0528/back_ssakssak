package com.kb.controller.teacher;

import com.kb.deposit.domain.Deposit;
import com.kb.deposit.dto.DepositDTO;
import com.kb.deposit.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/deposit/{id}")
    public ResponseEntity<String> deleteDeposit(@PathVariable long id) {
        depositService.deleteDeposit(id);
        return ResponseEntity.ok("예금 상품을 삭제했습니다");
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> addDeposit(@RequestBody Deposit deposit) {
        depositService.addDeposit(deposit);
        return ResponseEntity.ok(deposit.getDepositName() + " 예금 상품을 등록했습니다.");
    }
}