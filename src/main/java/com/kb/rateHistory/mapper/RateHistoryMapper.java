package com.kb.rateHistory.mapper;

import com.kb.stock.domain.RateHistory;

import java.util.List;

public interface RateHistoryMapper {
    List<RateHistory> selectRateHistory();
}
