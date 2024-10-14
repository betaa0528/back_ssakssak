package com.kb.controller.teacher;

import com.kb.stock.domain.StockNews;
import com.kb.stock.dto.RateHistoryDTO;
import com.kb.stock.dto.StockChartDTO;
import com.kb.stock.dto.StockNewsDTO;
import com.kb.stock.dto.StockNewsRequest;
import com.kb.stock.service.StockService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/stock")
@RequiredArgsConstructor
@Slf4j
@Api(value = "TeacherStockController", tags = "선생님 주식 관리 페이지")
@PropertySource({"classpath:/application.properties"})
public class TeacherStockController {

    private final StockService stockService;

    @GetMapping("/rate-history")
    public ResponseEntity<List<RateHistoryDTO>> getRateHistoryLast5Days() {
        List<RateHistoryDTO> historyLast5Days = stockService.getRateHistoryLast5Days();
        return ResponseEntity.ok(historyLast5Days);
    }

    @PostMapping("/rate-apply")
    public ResponseEntity<RateHistoryDTO> createRate(@RequestBody RateHistoryDTO rateHistoryDTO) {
        RateHistoryDTO rateHistory = stockService.createRateHistory(rateHistoryDTO);

        return ResponseEntity.ok(rateHistory);
    }

    @GetMapping("/news/list")
    public ResponseEntity<List<StockNewsDTO>> getStockNewsList() {
        List<StockNewsDTO> newsList = stockService.getStockNewsList();
        return ResponseEntity.ok(newsList);
    }

    @PostMapping("/news")
    public ResponseEntity<String> createNews(@RequestBody StockNewsRequest request) {
        stockService.createStockNews(request);

        return ResponseEntity.ok("뉴스 생성 성공");
    }

    @GetMapping("/chart")
    public ResponseEntity<StockChartDTO> getStockChart() {
        StockChartDTO stockChartDTO = stockService.getStockChartDTO();
        return ResponseEntity.ok(stockChartDTO);
    }

    @PostMapping("/news/{newsId}")
    public ResponseEntity<StockNews> deleteNews(@PathVariable Long newsId) {
        StockNews stockNews = stockService.deleteNews(newsId);
        return ResponseEntity.ok(stockNews);
    }
}
