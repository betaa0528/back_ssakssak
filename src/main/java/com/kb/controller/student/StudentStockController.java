package com.kb.controller.student;

import com.kb.member.dto.Member;
import com.kb.stock.domain.HoldingStock;
import com.kb.stock.domain.RateHistory;
import com.kb.stock.dto.StockNewsDTO;
import com.kb.stock.dto.StockTradeRequest;
import com.kb.stock.domain.StockTrade;
import com.kb.stock.service.StockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/stock")
@RequiredArgsConstructor
@Slf4j
@Tag(description = "StudentStockController", name = "학생 주식 정보")
@PropertySource({"classpath:/application.yml"})
public class StudentStockController {

    private final StockService stockService;

    @GetMapping("/data")
    public ResponseEntity<List<RateHistory>> getHistories() {
        List<RateHistory> histories = stockService.getRateHistories();

        return ResponseEntity.ok(histories);
    }

    @GetMapping("/news")
    public ResponseEntity<List<StockNewsDTO>> getNewsList() {
        List<StockNewsDTO> newsList = stockService.getStockNewsList();
        return ResponseEntity.ok(newsList);
    }

    @GetMapping("/trade")
    public ResponseEntity<List<StockTrade>> getStockTradeList() {
        List<StockTrade> tradeList = stockService.getStockTradeList();

        return ResponseEntity.ok(tradeList);
    }

    @PostMapping("/buy")
    public ResponseEntity<HoldingStock> buyStock(@RequestBody StockTradeRequest request) throws IllegalAccessException {
        stockService.buyStock(request);
        HoldingStock holdingStock = stockService.getHoldingStock(request.getUsername(), request.getName());

        return ResponseEntity.status(HttpStatus.OK).body(holdingStock);
    }

    @PostMapping("/sell")
    public ResponseEntity<HoldingStock> sellStock(@RequestBody StockTradeRequest request) {
        stockService.sellStock(request);
        HoldingStock holdingStock = stockService.getHoldingStock(request.getUsername(), request.getName());

        return ResponseEntity.status(HttpStatus.OK).body(holdingStock);
    }

    @GetMapping("/my-stock")
    public ResponseEntity<HoldingStock> getHoldingStock(@AuthenticationPrincipal Member principal) throws Exception {
        HoldingStock holdingStock = stockService.getHoldingStock(principal.getUsername(), principal.getName());
        return ResponseEntity.ok(holdingStock);
    }


}
