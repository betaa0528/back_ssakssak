package com.kb.tax.service;

import com.kb.tax.mapper.TaxMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaxService {

    private final TaxMapper taxMapper;

    public int getWeeklyTaxTotal() {
        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = today.minusDays(7);
        return taxMapper.getTaxTotalForLastWeek(oneWeekAgo, today.minusDays(1));  // 오늘 제외하고 7일 전부터 어제까지 조회
    }
}