package com.kb.rateHistory.mapper;

import com.kb.stock.domain.RateHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RateHistoryMapper {
    List<RateHistory> selectRateHistory();
}
