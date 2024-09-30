package com.kb.rateHistory.mapper;

import com.kb.rateHistory.dto.RateHistoryDTO;

import java.util.List;

public interface RateHistoryMapper {
    List<RateHistoryDTO> selectRateHistory();
}
