package com.kb.controller.teacher;

import com.kb.tax.domain.TaxPolicy;
import com.kb.tax.dto.TaxPolicyDTO;
import com.kb.tax.service.TaxService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tax-policy/{policyType}")
    public ResponseEntity<TaxPolicy> getTaxPolicy(@PathVariable String policyType) {

        return ResponseEntity.ok(taxService.getTaxPolicyByType(policyType));
    }

    @PutMapping("/tax-policy/apply")
    public ResponseEntity<String> updateTaxPolicy(@RequestBody TaxPolicyDTO taxPolicyDTO) {
        taxService.updateTaxPolicy(taxPolicyDTO);
        return ResponseEntity.ok("Tax policy updated successfully!");
    }
}