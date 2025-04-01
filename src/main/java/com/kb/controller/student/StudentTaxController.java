package com.kb.controller.student;

import com.kb.tax.dto.TaxPolicyDTO;
import com.kb.tax.service.TaxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/student/home")
@RequiredArgsConstructor
@Slf4j
public class StudentTaxController {

    private final TaxService taxService;

    @GetMapping("/weeklytax")
    public TaxPolicyDTO getLatestWeeklyTax() {
        return taxService.getLatestWeeklyTax();
    }


}
