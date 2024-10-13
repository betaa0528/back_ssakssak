package com.kb.controller.teacher;

import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingAddPrimeRateDTO;
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
    public ResponseEntity<SavingAddPrimeRateDTO> saveSaving(@RequestBody Saving saving) {
        savingService.addSaving(saving);
    }
}