package com.kb.stockNews.service;

import com.kb.stock.domain.StockNews;
import com.kb.stockNews.mapper.StockNewsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@RequiredArgsConstructor
@Service
public class StockNewsService {

    private final StockNewsMapper stockNewsMapper;

    public List<StockNews> getStockNewsList() {
        return stockNewsMapper.selectStockNews();
    }
}
