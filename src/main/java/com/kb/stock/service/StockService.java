package com.kb.stock.service;

import com.kb.stock.domain.RateHistory;
import com.kb.stock.domain.StockNews;
import com.kb.stock.domain.StockTrade;
import com.kb.stock.dto.StockTradeRequest;
import com.kb.stock.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public int buyStock(StockTradeRequest request) {
        return stockMapper.insertStockBuy(request);
    }


    public int sellStock(StockTradeRequest request) {
        return stockMapper.insertStockSell(request);
    }
}
