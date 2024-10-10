package com.kb.stock.service;

import com.kb.stock.domain.RateHistory;
import com.kb.stock.domain.StockNews;
import com.kb.stock.domain.StockTrade;
import com.kb.stock.dto.*;
import com.kb.stock.mapper.StockMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j
@RequiredArgsConstructor
@Service
@PropertySource({"classpath:/application.properties"})
public class StockService {

    private final StockMapper stockMapper;
    private final StudentMapper studentMapper;

    public List<RateHistory> getRateHistories() {
        return stockMapper.selectRateHistory();
    }

    public List<StockNews> getStockNewsList() {
        return stockMapper.selectStockNews();
    }

    public List<StockTrade> getStockTradeList() {
        return stockMapper.selectStockTradeList();
    }

    @Transactional
    public void buyStock(StockTradeRequest stockTradeRequest) {
        Student student = Student.of(studentMapper.selectStudentByUsernameAndName
                (stockTradeRequest.getUsername(), stockTradeRequest.getName()));

        int buyTotalPrice = stockTradeRequest.getQuantity() * stockTradeRequest.getStockPrice();

        if(student.getStdSeed() < buyTotalPrice) {
            throw new IllegalArgumentException("보유한 씨드가 부족합니다.");
        }

        int currentPrice = stockMapper.selectCurrentStockPrice();

        TradeRequest tradeRequest = new TradeRequest();
        tradeRequest.setStdId(student.getStdId());
        tradeRequest.setTchId(student.getTchId());
        tradeRequest.setQuantity(stockTradeRequest.getQuantity());
        tradeRequest.setStockPrice(stockTradeRequest.getStockPrice());

        int result = stockMapper.insertStockBuy(tradeRequest);

        HoldingStockDTO holdingStockDTO = getHoldingStock(stockTradeRequest.getUsername(), stockTradeRequest.getName());

        int totalInvestment = holdingStockDTO.getTotalInvestment() + tradeRequest.getQuantity() * tradeRequest.getStockPrice();
        int totalQuantity = holdingStockDTO.getTotalQuantity() + tradeRequest.getQuantity();
        double averagePrice = (double) totalInvestment / totalQuantity;
        double currentValue = currentPrice * totalQuantity;
        double profitLoss = currentValue - totalInvestment;
        double profitRate = (profitLoss / totalInvestment) * 100;

        holdingStockDTO.setTotalQuantity(totalQuantity);
        holdingStockDTO.setTotalInvestment(totalInvestment);
        holdingStockDTO.setAveragePrice(averagePrice);
        holdingStockDTO.setCurrentValue(currentValue);
        holdingStockDTO.setProfitLoss(profitLoss);
        holdingStockDTO.setProfitRate(profitRate);

        studentMapper.updateStudentSeed(student.getStdId(), -buyTotalPrice);
        int holdingStockResult = stockMapper.updateHoldingStock(holdingStockDTO);
        if (holdingStockResult != 1 || result != 1) {
            throw new NoSuchElementException();
        }
    }

    @Transactional
    public void sellStock(StockTradeRequest stockTradeRequest) {
        Student student = Student.of(studentMapper.selectStudentByUsernameAndName
                (stockTradeRequest.getUsername(), stockTradeRequest.getName()));

        int sellTotalPrice = stockTradeRequest.getQuantity() * stockTradeRequest.getStockPrice();
        int currentPrice = stockMapper.selectCurrentStockPrice();

        TradeRequest tradeRequest = new TradeRequest();
        tradeRequest.setStdId(student.getStdId());
        tradeRequest.setTchId(student.getTchId());
        tradeRequest.setQuantity(stockTradeRequest.getQuantity());
        tradeRequest.setStockPrice(stockTradeRequest.getStockPrice());

        int result = stockMapper.insertStockSell(tradeRequest);

        HoldingStockDTO holdingStockDTO = getHoldingStock(stockTradeRequest.getUsername(), stockTradeRequest.getName());

        int totalInvestment = holdingStockDTO.getTotalInvestment() - tradeRequest.getQuantity() * tradeRequest.getStockPrice();
        int totalQuantity = holdingStockDTO.getTotalQuantity() - tradeRequest.getQuantity();
        double averagePrice = (double) totalInvestment / totalQuantity;
        double currentValue = currentPrice * totalQuantity;
        double profitLoss = currentValue - totalInvestment;
        double profitRate = profitLoss / totalInvestment * 100;

        holdingStockDTO.setTotalQuantity(totalQuantity);
        holdingStockDTO.setTotalInvestment(totalInvestment);
        holdingStockDTO.setAveragePrice(averagePrice);
        holdingStockDTO.setCurrentValue(currentValue);
        holdingStockDTO.setProfitLoss(profitLoss);
        holdingStockDTO.setProfitRate(profitRate);

        studentMapper.updateStudentSeed(student.getStdId(), sellTotalPrice);
        int holdingStockResult = stockMapper.updateHoldingStock(holdingStockDTO);
        if (holdingStockResult != 1 || result != 1) {
            throw new NoSuchElementException();
        }
    }

    public HoldingStockDTO getHoldingStock(String username, String name) {
        Student student = Student.of(studentMapper.selectStudentByUsernameAndName
                (username, name));
        return stockMapper.selectHoldingStock(student.getStdId());
    }

    public List<RateHistoryDTO> getRateHistoryLast5Days() {
        return stockMapper.selectRateHistoryLast5Days();
    }

    public RateHistoryDTO createRateHistory(RateHistoryDTO rateHistoryDTO) {
        stockMapper.insertRateHistory(rateHistoryDTO);
        return getRateHistoryLast5Days().get(0);
    }

    public StockNews createStockNews(StockNewsRequest request) {
        stockMapper.insertStockNews(request);

        StockNews stockNews = getStockNewsList().get(0);
        return stockNews;
    }

    public List<ChartDataDTO> getChartDataDTO() {
        return stockMapper.selectChartData();
    }

    public StockChartDTO getStockChartDTO() {
        StockChartDTO stockChartDTO = stockMapper.selectStockChart();
        stockChartDTO.setChartData(getChartDataDTO());
        return stockChartDTO;
    }

    public StockNews getStockNewsById(long id) {
        StockNews stockNews = stockMapper.selectStockNewsById(id);
        return Optional.of(stockNews).orElseThrow(NoSuchElementException::new);
    }

    public StockNews deleteNews(long newsId) {
        StockNews stockNews = getStockNewsById(newsId);
        int result = stockMapper.deleteStockNews(newsId);
        if(result != 1) {
            throw new NoSuchElementException();
        }

        return stockNews;
    }
}
