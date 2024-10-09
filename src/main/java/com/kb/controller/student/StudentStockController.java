package com.kb.controller.student;

import com.kb.stock.domain.RateHistory;
import com.kb.stock.domain.StockNews;
import com.kb.stock.dto.HoldingStockDTO;
import com.kb.stock.dto.StockTradeRequest;
import com.kb.stock.dto.TradeRequest;
import com.kb.stock.domain.StockTrade;
import com.kb.stock.service.StockService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/stock")
@RequiredArgsConstructor
@Slf4j
@Api(value = "StudentStockController", tags = "학생 주식 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentStockController {

    private final StockService stockService;

    @GetMapping("/data")
    public ResponseEntity<List<RateHistory>> getHistories() {
        List<RateHistory> histories = stockService.getRateHistories();

        return ResponseEntity.ok(histories);
    }

    @GetMapping("/news")
    public ResponseEntity<List<StockNews>> getNewsList() {
        List<StockNews> newsList = stockService.getStockNewsList();

        return ResponseEntity.ok(newsList);
    }

    @GetMapping("/trade")
    public ResponseEntity<List<StockTrade>> getStockTradeList() {
        List<StockTrade> tradeList = stockService.getStockTradeList();

        return ResponseEntity.ok(tradeList);
    }

    @PostMapping("/buy")
    public ResponseEntity<HoldingStockDTO> buyStock(@RequestBody StockTradeRequest request) {
        int result = stockService.buyStock(request);
        HoldingStockDTO holdingStock = stockService.getHoldingStock(request.getStdId());

        return ResponseEntity.status(HttpStatus.OK).body(holdingStock);
    }

    @PostMapping("/sell")
    public ResponseEntity<HoldingStockDTO> sellStock(@RequestBody TradeRequest request) {
        int result = stockService.sellStock(request);
        HoldingStockDTO holdingStock = stockService.getHoldingStock(request.getStdId());

        return ResponseEntity.status(HttpStatus.OK).body(holdingStock);
    }

    @GetMapping("/my-stock/{stdId}")
    public ResponseEntity<HoldingStockDTO> getHoldingStock(@PathVariable long stdId) throws Exception {
        HoldingStockDTO holdingStock = stockService.getHoldingStock(stdId);
        if (holdingStock == null) {
            throw new Exception("해당 학생의 보유주식 없음");
        }
        return ResponseEntity.ok(holdingStock);
    }


}
