package com.kb.stock.mapper;

import com.kb.stock.domain.RateHistory;
import com.kb.stock.domain.StockNews;
import com.kb.stock.domain.StockTrade;
import com.kb.stock.dto.*;

import java.util.List;

public interface StockMapper {
    List<StockTrade> selectStockTradeList();
    List<StockNews> selectStockNews();
    StockNews selectStockNewsById(long newsId);
    List<RateHistory> selectRateHistory();
    int insertStockBuy(StockTradeRequest request);
    int insertStockSell(StockTradeRequest request);
    int insertHoldingStock(HoldingStockDTO holdingStockDTO);
    int updateHoldingStock(HoldingStockDTO holdingStockDTO);
    HoldingStockDTO selectHoldingStock(long stdId);

    List<RateHistoryDTO> selectRateHistoryLast5Days();

    int insertRateHistory(RateHistoryDTO rateHistoryDTO);

    int insertStockNews(StockNewsRequest request);
    StockChartDTO selectStockChart();
    List<ChartDataDTO> selectChartData();

    int deleteStockNews(long newsId);
}
