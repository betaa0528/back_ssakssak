package com.kb.stock.mapper;

import com.kb.stock.domain.RateHistory;
import com.kb.stock.dto.ChartDataDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class StockMapperTest {

    @Autowired
    private StockMapper stockMapper;

    @Test
    void 주식가격변동조회() {
        List<RateHistory> rateHistories = stockMapper.selectRateHistory();
        assertNotNull(rateHistories);
        assertEquals(1, rateHistories.get(0).getRateHistoryId());

    }
}