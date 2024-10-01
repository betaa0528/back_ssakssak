package com.kb.stockTrade.mapper;

import com.kb.stock.domain.StockTrade;

import java.util.List;

public interface StockTradeMapper {
    List<StockTrade> selectStockTradeList();
}
