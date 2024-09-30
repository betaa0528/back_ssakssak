package com.kb.rateHistory.service;

import com.kb.rateHistory.dto.RateHistoryDTO;
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
public class StockService {

    private final RateHistoryMapper mapper;

    public List<RateHistoryDTO> getRateHistories() {
        List<RateHistoryDTO> histories = mapper.selectRateHistory();
        log.info(histories);
        return histories;
    }
}
