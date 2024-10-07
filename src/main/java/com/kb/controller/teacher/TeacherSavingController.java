package com.kb.controller.teacher;

import com.kb.saving.dto.SavingDTO;
import com.kb.saving.service.SavingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/bank")
@RequiredArgsConstructor
public class TeacherSavingController {

    private final SavingService savingService;

    @GetMapping("/saving-list")
    public ResponseEntity<List<SavingDTO>> getSavingList() {
        List<SavingDTO> savingList = savingService.getSavingProduct();
        return ResponseEntity.ok(savingList);
    }
}