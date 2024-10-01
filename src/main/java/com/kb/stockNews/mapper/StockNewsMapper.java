package com.kb.stockNews.mapper;

import com.kb.stock.domain.StockNews;

import java.util.List;

public interface StockNewsMapper {
    List<StockNews> selectStockNews();
}
