package com.kb.stockTrade.service;

import com.kb.stock.domain.StockTrade;
import com.kb.stockTrade.mapper.StockTradeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@RequiredArgsConstructor
@Service
public class StockTradeService {

    private final StockTradeMapper stockTradeMapper;


    public List<StockTrade> getStockTradeList() {
        return stockTradeMapper.selectStockTradeList();
    }


}
