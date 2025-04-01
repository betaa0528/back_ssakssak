package com.kb.controller.teacher;

import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingAddPrimeRateDTO;
import com.kb.saving.dto.SavingAddRequest;
import com.kb.saving.dto.SavingDTO;
import com.kb.saving.service.SavingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/bank")
@RequiredArgsConstructor
public class TeacherSavingController {

    private final SavingService savingService;

    @GetMapping("/saving-list")
    public ResponseEntity<List<SavingAddPrimeRateDTO>> getSavingList() {
        List<SavingAddPrimeRateDTO> savingList = savingService.getAllSavingList();
        return ResponseEntity.ok(savingList);
    }

    @PostMapping("/saving")
    public ResponseEntity<String> saveSaving(@RequestBody SavingAddRequest request) {
        savingService.addSaving(request);
        return ResponseEntity.ok("적금 등록에 성공했습니다.");
    }

    @PostMapping("/saving/{id}")
    public ResponseEntity<String> deleteSaving(@PathVariable long id) {
        savingService.deleteSaving(id);
        return ResponseEntity.ok("적금 상품을 삭제 했습니다.");
    }
}