package com.kb.stock.mapper;

import com.kb.stock.domain.HoldingStock;
import com.kb.stock.domain.RateHistory;
import com.kb.stock.domain.StockNews;
import com.kb.stock.domain.StockTrade;
import com.kb.stock.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    List<StockTrade> selectStockTradeList();
    List<StockNews> selectStockNews();
    StockNews selectStockNewsById(long newsId);
    List<RateHistory> selectRateHistory();
    int insertStockBuy(TradeRequest request);
    int insertStockSell(TradeRequest request);
    int insertHoldingStock(HoldingStock holdingStock);
    int updateHoldingStock(HoldingStock holdingStock);
    HoldingStock selectHoldingStock(long stdId);

    List<RateHistoryDTO> selectRateHistoryLast5Days();

    int insertRateHistory(RateHistoryDTO rateHistory);

    int insertStockNews(StockNewsRequest request);
    StockChartDTO selectStockChart();
    List<ChartDataDTO> selectChartData();

    int deleteStockNews(long newsId);

    int selectCurrentStockPrice();
}
