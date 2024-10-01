package com.kb.stock.mapper;

import com.kb.stock.domain.RateHistory;
import com.kb.stock.domain.StockNews;
import com.kb.stock.domain.StockTrade;
import com.kb.stock.dto.StockTradeRequest;

import java.util.List;

public interface StockMapper {
    List<StockTrade> selectStockTradeList();
    List<StockNews> selectStockNews();
    List<RateHistory> selectRateHistory();
    int insertStockBuy(StockTradeRequest request);
    int insertStockSell(StockTradeRequest request);

}
