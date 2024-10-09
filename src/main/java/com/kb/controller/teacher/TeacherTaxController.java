package com.kb.controller.teacher;

import com.kb.tax.service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher/bank")
@RequiredArgsConstructor
public class TeacherTaxController {

    private final TaxService taxService;

    @GetMapping("/tax-week")
    public ResponseEntity<Integer> getWeeklyTaxTotal() {
        int totalAmount = taxService.getWeeklyTaxTotal();
        return ResponseEntity.ok(totalAmount);
    }
}