package com.kb.rateHistory.service;

import com.kb.stock.domain.RateHistory;
import com.kb.rateHistory.mapper.RateHistoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class RateHistoryService {

    private final RateHistoryMapper rateHistoryMapper;

    public List<RateHistory> getRateHistories() {
        return rateHistoryMapper.selectRateHistory();
    }

}
