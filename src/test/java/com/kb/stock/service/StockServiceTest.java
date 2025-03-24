package com.kb.stock.service;

import com.kb.common.enums.OrderStatus;
import com.kb.common.enums.OrderType;
import com.kb.common.exception.SsakssakApplicationException;
import com.kb.stock.domain.HoldingStock;
import com.kb.stock.domain.StockOrderBook;
import com.kb.stock.dto.StockOrderBookRequest;
import com.kb.stock.dto.StockTradeRequest;
import com.kb.stock.mapper.StockMapper;
import com.kb.stock.mapper.StockOrderBookMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class StockServiceTest {

    @Mock
    private StockMapper stockMapper;

    @Mock
    private StockOrderBookMapper stockOrderBookMapper;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StockService stockService;

    private Student mockStudent() {
        return Student.builder()
                .stdId(1L)
                .tchId(1L)
                .stdNum(1)
                .stdName("minjoop")
                .stdAccount("박민주")
                .stdPw("1234")
                .stdBirth("1994-05-28")
                .jobId(1L)
                .seed(5000)
                .build();
    }

    @DisplayName("주식을 구매하고자 할 때 돈이 가지고 있는 돈이 부족하면 에러를 발생시킨다.")
    @Test
    void buyStock_Given_InsufficientBalance_Then_ThrowException() {
        // given
        StockTradeRequest stockTradeRequest = new StockTradeRequest("minjoop", "박민주", 10, 1000);

        Student student = mockStudent();

        when(studentMapper.selectStudentByUsernameAndStdName(stockTradeRequest.getUsername(), stockTradeRequest.getName()))
                .thenReturn(student);


        // when
        assertThatThrownBy(() -> stockService.buyStock(stockTradeRequest))
                .isInstanceOf(SsakssakApplicationException.class)
                .hasMessage("보유한 씨드가 부족합니다.");
    }

    @DisplayName("주식 매도 요청시 보유한 수량보다 많이 팔고자 할 때 에러발생")
    @Test
    void sellStock_Given_InsufficientQuantity_Then_ThrowException() {
        // given
        StockTradeRequest stockTradeRequest = new StockTradeRequest("minjoop", "박민주", 50, 1000);


        HoldingStock mock = HoldingStock.builder()
                .stdId(1L)
                .totalQuantity(5)
                .totalInvestment(10000)
                .averagePrice(2000.0)
                .currentValue(1000.0)
                .profitLoss(-20.0)
                .profitRate(20.0)
                .build();

        Student student = mockStudent();

        when(studentMapper.selectStudentByUsernameAndStdName(stockTradeRequest.getUsername(), stockTradeRequest.getName()))
                .thenReturn(student);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(mock);

        assertThatThrownBy(() -> stockService.sellStock(stockTradeRequest))
                .isInstanceOf(SsakssakApplicationException.class)
                .hasMessage("잘못된 주식 수량입니다.");
    }

    @DisplayName("주식 매도 요청시 수량이  0이거나 음수이면 에러발생 ")
    @Test
    void sellStock_Given_InsufficientQuantityZeroOrNegative_Then_ThrowException() {
        StockTradeRequest stockTradeRequest = new StockTradeRequest("minjoop", "박민주", 0,1000);

        Student student = mockStudent();
        HoldingStock mock = HoldingStock.builder()
                .stdId(1L)
                .totalQuantity(5)
                .totalInvestment(10000)
                .averagePrice(2000.0)
                .currentValue(1000.0)
                .profitLoss(-20.0)
                .profitRate(20.0)
                .build();

        when(studentMapper.selectStudentByUsernameAndStdName(stockTradeRequest.getUsername(), stockTradeRequest.getName())).thenReturn(student);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(mock);

        assertThatThrownBy(() -> stockService.sellStock(stockTradeRequest))
                .isInstanceOf(SsakssakApplicationException.class)
                .hasMessage("잘못된 주식 수량입니다.");

    }


    @DisplayName("주식 매도 요청 시 매도 주문이 매물 목록에 등록된다.")
    @Test
    void sellStock_success() {
        // given
        StockTradeRequest stockTradeRequest = new StockTradeRequest("minjoop", "박민주", 5, 1000);
        HoldingStock mock = HoldingStock.builder()
                .stdId(1L)
                .totalQuantity(5)
                .totalInvestment(10000)
                .averagePrice(2000.0)
                .currentValue(1000.0)
                .profitLoss(-20.0)
                .profitRate(20.0)
                .build();

        Student student = mockStudent();

        when(studentMapper.selectStudentByUsernameAndStdName(stockTradeRequest.getUsername(), stockTradeRequest.getName()))
                .thenReturn(student);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(mock);
        when(stockOrderBookMapper.insertStockOrderBook(any())).thenReturn(1);


        ArgumentCaptor<StockOrderBookRequest> captor = ArgumentCaptor.forClass(StockOrderBookRequest.class);

        // when
        stockService.sellStock(stockTradeRequest);

        // then
        verify(stockOrderBookMapper, times(1)).insertStockOrderBook(captor.capture());

        StockOrderBookRequest savedOrder = captor.getValue();
        assertThat(savedOrder.getStdId()).isEqualTo(student.getStdId());
        assertThat(savedOrder.getQuantity()).isEqualTo(stockTradeRequest.getQuantity());
        assertThat(savedOrder.getPrice()).isEqualTo(stockTradeRequest.getStockPrice());
        assertThat(savedOrder.getOrderType()).isEqualTo(OrderType.SELL); // enum이 정확히 들어갔는지도 체크

    }

    @DisplayName("현재 등록된 매물 리스트 중 매도건(OPEN) 조회")
    @Test
    void getStockOrderBookList_success() {
        List<StockOrderBook> mockList = List.of(
                new StockOrderBook(1L, 1L, 1L, OrderType.SELL, 10,1000, OrderStatus.OPEN, LocalDateTime.now()),
                new StockOrderBook(2L, 2L, 1L, OrderType.SELL, 10,1000, OrderStatus.OPEN, LocalDateTime.now()),
                new StockOrderBook(3L, 3L, 1L, OrderType.SELL, 10,1000, OrderStatus.OPEN, LocalDateTime.now())
        );

        when(stockOrderBookMapper.selectSellStockOrderBookList()).thenReturn(mockList);

        List<StockOrderBook> result = stockService.getSellStockOrderBookList();

        assertEquals(3, result.size());
    }

    @DisplayName("매수 요청시 원하는 매물이 없을시 매물 리스트에 등록")
    @Test
    void buyStock_noStock_thenInsertStockOrderBook() {
        StockTradeRequest request = new StockTradeRequest("minjoop", "박민주", 10, 1000);
        Student student = mockStudent();

        student.setSeed(1000000);

        when(studentMapper.selectStudentByUsernameAndStdName(request.getUsername(), request.getName()))
                .thenReturn(student);
        when(stockOrderBookMapper.selectAvailableSellOrdersUnderPrice(anyLong(), anyInt())).thenReturn(Collections.EMPTY_LIST);
        when(stockOrderBookMapper.insertStockOrderBook(any())).thenReturn(1);

        ArgumentCaptor<StockOrderBookRequest> captor = ArgumentCaptor.forClass(StockOrderBookRequest.class);

        stockService.buyStock(request);
        verify(stockOrderBookMapper, times(1)).insertStockOrderBook(captor.capture());

        StockOrderBookRequest savedOrder = captor.getValue();
        assertThat(savedOrder.getStdId()).isEqualTo(student.getStdId());
        assertThat(savedOrder.getQuantity()).isEqualTo(request.getQuantity());
        assertThat(savedOrder.getPrice()).isEqualTo(request.getStockPrice());
        assertThat(savedOrder.getOrderType()).isEqualTo(OrderType.BUY);
    }

    @DisplayName("매수 요청시 충분한 수량이 있을시 매수 체결")
    @Test
    void buyStock_When_EnoughSellQuantityExists_Should_ExecuteTransaction() {
        StockTradeRequest request = new StockTradeRequest("minjoop", "박민주", 10, 1000);
        Student student = mockStudent();

        List<StockOrderBook> mockList = List.of(
                new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 10,1000, OrderStatus.OPEN, LocalDateTime.now())
        );
        student.setSeed(1000000);
        when(studentMapper.selectStudentByUsernameAndStdName(request.getUsername(), request.getName()))
                .thenReturn(student);
        when(stockOrderBookMapper.selectAvailableSellOrdersUnderPrice(anyLong(), anyInt())).thenReturn(mockList);
        stockService.buyStock(request);

    }
}