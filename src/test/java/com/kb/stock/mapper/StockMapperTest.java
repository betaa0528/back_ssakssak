package com.kb.stock.mapper;

import com.kb._config.RootConfig;
import com.kb.stock.domain.StockNews;
import com.kb.stock.dto.ChartDataDTO;
import com.kb.stock.dto.StockNewsRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class})
class StockMapperTest {

    @Autowired
    private StockMapper stockMapper;

    @Test
    @DisplayName("최근 30일간의 날짜와 주식 가격 데이터를 가져온다.")
    void selectChartData() {
        List<ChartDataDTO> chartDataDTOList = stockMapper.selectChartData();
        assertEquals(95, chartDataDTOList.get(0).getStockPrice() );
    }

    @Test
    @DisplayName("주식 뉴스의 아이디에 해당하는 뉴스를 하나 가져온다.")
    void selectStockNewsById() {
        StockNews stockNews = stockMapper.selectStockNews().get(0);
        StockNews stockNews1 = stockMapper.selectStockNewsById(20L);
        assertEquals(stockNews.getTitle(), stockNews1.getTitle());
    }
}