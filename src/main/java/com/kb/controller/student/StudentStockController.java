package com.kb.controller.student;

import com.kb.rateHistory.dto.RateHistoryDTO;
import com.kb.rateHistory.service.StockService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student/stock")
@RequiredArgsConstructor
@Slf4j
@Api(value= "StudentStockController", tags = "학생 주식 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentStockController {

    private final StockService stockService;

    @GetMapping("/data")
    public ResponseEntity<List<RateHistoryDTO>> getHistories() {
        List<RateHistoryDTO> histories = stockService.getRateHistories();

        return ResponseEntity.ok(histories);
    }


}
