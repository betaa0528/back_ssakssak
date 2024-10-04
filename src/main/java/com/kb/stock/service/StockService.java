package com.kb.stock.service;

import com.kb.stock.domain.HoldingStock;
import com.kb.stock.domain.RateHistory;
import com.kb.stock.domain.StockNews;
import com.kb.stock.domain.StockTrade;
import com.kb.stock.dto.*;
import com.kb.stock.mapper.StockMapper;
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
    public int buyStock(StockTradeRequest request) {
        int result = stockMapper.insertStockBuy(request);

        HoldingStockDTO holdingStockDTO = getHoldingStock(request.getStdId());

        int totalInvestment = holdingStockDTO.getTotalInvestment() + request.getQuantity() * request.getStockPrice();
        int totalQuantity = holdingStockDTO.getTotalQuantity() + request.getQuantity();
        double averagePrice = (double) totalInvestment / totalQuantity;
        double currentValue = request.getStockPrice() * totalQuantity;
        double profitLoss = currentValue - totalInvestment;
        double profitRate = profitLoss / totalInvestment * 100;

        holdingStockDTO.setTotalQuantity(totalQuantity);
        holdingStockDTO.setTotalInvestment(totalInvestment);
        holdingStockDTO.setAveragePrice(averagePrice);
        holdingStockDTO.setCurrentValue(currentValue);
        holdingStockDTO.setProfitLoss(profitLoss);
        holdingStockDTO.setProfitRate(profitRate);

        int holdingStockResult = stockMapper.updateHoldingStock(holdingStockDTO);
        if (holdingStockResult != 1 || result != 1) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public int sellStock(StockTradeRequest request) {
        int result = stockMapper.insertStockSell(request);

        HoldingStockDTO holdingStockDTO = getHoldingStock(request.getStdId());

        int totalInvestment = holdingStockDTO.getTotalInvestment() - request.getQuantity() * request.getStockPrice();
        int totalQuantity = holdingStockDTO.getTotalQuantity() - request.getQuantity();
        double averagePrice = (double) totalInvestment / totalQuantity;
        double currentValue = request.getStockPrice() * totalQuantity;
        double profitLoss = currentValue - totalInvestment;
        double profitRate = profitLoss / totalInvestment * 100;

        holdingStockDTO.setTotalQuantity(totalQuantity);
        holdingStockDTO.setTotalInvestment(totalInvestment);
        holdingStockDTO.setAveragePrice(averagePrice);
        holdingStockDTO.setCurrentValue(currentValue);
        holdingStockDTO.setProfitLoss(profitLoss);
        holdingStockDTO.setProfitRate(profitRate);

        int holdingStockResult = stockMapper.updateHoldingStock(holdingStockDTO);
        if (holdingStockResult != 1 || result != 1) {
            throw new NoSuchElementException();
        }

        return result;
    }

    public HoldingStockDTO getHoldingStock(long stdId) {
        return stockMapper.selectHoldingStock(stdId);
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
