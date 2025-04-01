package com.kb.stock.service;

import com.kb.common.enums.OrderStatus;
import com.kb.common.enums.OrderType;
import com.kb.common.exception.SsakssakApplicationException;
import com.kb.stock.domain.HoldingStock;
import com.kb.stock.domain.RateHistory;
import com.kb.stock.domain.StockOrderBook;
import com.kb.stock.dto.StockOrderBookRequest;
import com.kb.stock.dto.StockTradeRequest;
import com.kb.stock.mapper.StockMapper;
import com.kb.stock.mapper.StockOrderBookMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
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

    private OrderMatchingService orderMatchingService;
    private StockService stockService;

    @BeforeEach
    void setUp() {
        orderMatchingService = new OrderMatchingService(studentMapper,stockOrderBookMapper,stockMapper);
        stockService = new StockService(stockMapper, studentMapper, stockOrderBookMapper,orderMatchingService );
    }

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

    private HoldingStock mockHoldingStock() {
            return HoldingStock.builder()
            .stdId(1L)
            .totalQuantity(5)
            .totalInvestment(10000)
            .averagePrice(2000.0)
            .currentValue(1000.0)
            .profitLoss(-20.0)
            .profitRate(20.0)
            .build();

    }

    private StockTradeRequest mockStockTradeRequest() {
        return StockTradeRequest.builder()
                .stdId(1L)
                .username("minjoop")
                .name("박민주")
                .quantity(10)
                .stockPrice(1000)
                .build();
    }

    @DisplayName("주식을 구매하고자 할 때 돈이 가지고 있는 돈이 부족하면 에러를 발생시킨다.")
    @Test
    void buyStock_Given_InsufficientBalance_Then_ThrowException() {
        // given
        StockTradeRequest stockTradeRequest = new StockTradeRequest(1L, "minjoop", "박민주", 10, 1000);

        Student student = mockStudent();
        HoldingStock mockHoldingStock = mockHoldingStock();

        when(studentMapper.selectStudentByUsernameAndStdName(stockTradeRequest.getUsername(), stockTradeRequest.getName()))
                .thenReturn(student);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(mockHoldingStock);


        // when
        assertThatThrownBy(() -> stockService.buyStock(stockTradeRequest))
                .isInstanceOf(SsakssakApplicationException.class)
                .hasMessage("보유한 씨드가 부족합니다.");
    }



    @DisplayName("매수 요청시 원하는 매물이 없을시 매물 리스트에 등록")
    @Test
    void buyStock_noStock_thenInsertStockOrderBook() {
        StockTradeRequest request = new StockTradeRequest(1L , "minjoop", "박민주", 10, 1000);
        Student student = mockStudent();


        student.setSeed(1000000);
        HoldingStock mockHoldingStock = mockHoldingStock();

        when(studentMapper.selectStudentByUsernameAndStdName(request.getUsername(), request.getName()))
                .thenReturn(student);
        when(stockMapper.selectHoldingStock(student.getStdId())).thenReturn(mockHoldingStock);
        when(stockOrderBookMapper.selectAvailableSellOrdersUnderPrice(anyLong(), anyInt())).thenReturn(Collections.EMPTY_LIST);




        stockService.buyStock(request);

        verify(stockOrderBookMapper, never()).insertStockOrderBook(argThat(order ->
                order.getStatus() == OrderStatus.COMPLETED
        ));

        verify(stockOrderBookMapper).insertStockOrderBook(argThat(order ->
                order.getOrderType() == OrderType.BUY &&
                        order.getStatus() == OrderStatus.OPEN &&
                        order.getQuantity() == request.getQuantity()
        ));

    }

    @DisplayName("매수 요청시 충분한 수량이 있을시 매수 체결")
    @Test
    void buyStock_When_EnoughSellQuantityExists_Should_ExecuteTransaction() {
        StockTradeRequest request = new StockTradeRequest(1L, "minjoop", "박민주", 10, 1000);
        Student student = mockStudent();

        List<StockOrderBook> mockList = List.of(
                new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 10,1000, OrderStatus.OPEN, LocalDateTime.now())
        );
        student.setSeed(1000000);
        when(studentMapper.selectStudentByUsernameAndStdName(request.getUsername(), request.getName()))
                .thenReturn(student);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(mockHoldingStock());
        when(stockOrderBookMapper.selectAvailableSellOrdersUnderPrice(anyLong(), anyInt())).thenReturn(mockList);

        Student mockSeller = mockStudent();
        mockSeller.setStdId(2L);
        mockSeller.setSeed(500);

        when(studentMapper.selectStudentById(2L)).thenReturn(mockSeller);
        when(stockMapper.selectHoldingStock(2L)).thenReturn(mockHoldingStock());

        stockService.buyStock(request);

    }

    @DisplayName("여러 판매자에게서 매수자가 8주를 구매할 때, 일부 매물만 체결됨")
    @Test
    void buyStock_When_MultipleSellOrdersExist_PartiallyFilled() {
        StockTradeRequest request = new StockTradeRequest(1L, "minjoop", "박민주", 8, 1000);
        Student buyer = mockStudent();
        buyer.setSeed(1000 * 10); // 충분한 씨드 보유

        StockOrderBook sellerA = new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 5, 1000, OrderStatus.OPEN, LocalDateTime.now());
        StockOrderBook sellerB = new StockOrderBook(2L, 3L, 1L, OrderType.SELL, 5, 1000, OrderStatus.OPEN, LocalDateTime.now());

        List<StockOrderBook> mockSellOrders = List.of(sellerA, sellerB);

        HoldingStock holdingStock = mockHoldingStock();
        holdingStock.setTotalQuantity(0);

        when(studentMapper.selectStudentByUsernameAndStdName(request.getUsername(), request.getName()))
                .thenReturn(buyer);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(holdingStock);
        when(stockOrderBookMapper.selectAvailableSellOrdersUnderPrice(1L, 1000))
                .thenReturn(mockSellOrders);

        Student mockSeller1 = mockStudent();
        mockSeller1.setStdId(2L);
        mockSeller1.setSeed(500);
        Student mockSeller2 = mockStudent();
        mockSeller2.setStdId(3L);
        mockSeller2.setSeed(500);

        HoldingStock holdingStock1 = mockHoldingStock();
        holdingStock1.setStdId(2L);
        HoldingStock holdingStock2 = mockHoldingStock();
        holdingStock1.setStdId(3L);

        when(studentMapper.selectStudentById(2L)).thenReturn(mockSeller1);
        when(studentMapper.selectStudentById(3L)).thenReturn(mockSeller2);
        when(stockMapper.selectHoldingStock(2L)).thenReturn(holdingStock1);
        when(stockMapper.selectHoldingStock(3L)).thenReturn(holdingStock2);

        stockService.buyStock(request);


        verify(stockOrderBookMapper).updateStockOrderBook(argThat(
                order -> order.getId().equals(1L) && order.getStatus() == OrderStatus.COMPLETED));
        verify(stockOrderBookMapper).updateStockOrderBook(argThat(
                order -> order.getId().equals(2L) && order.getStatus() == OrderStatus.OPEN && order.getQuantity() == 2));

        verify(stockOrderBookMapper).insertStockOrderBook(argThat(order ->
            order.getOrderType() == OrderType.BUY && order.getStatus() == OrderStatus.COMPLETED && order.getQuantity() == 8
        ));
    }

    @DisplayName("여러 판매자에게서 10주가 있을 때 매수자가 12주를 구매하면, 10주는 구매되고 2주는 구매 매물로 등록해놓음")
    @Test
    void buyStock_When_MultipleSellOrdersExist_thenInsertStockOrderBook() {
        StockTradeRequest request = new StockTradeRequest(1L, "minjoop", "박민주", 12, 1000);
        Student buyer = mockStudent();
        buyer.setSeed(1000 * 12); // 충분한 씨드 보유

        StockOrderBook sellerA = new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 5, 900, OrderStatus.OPEN, LocalDateTime.now());
        StockOrderBook sellerB = new StockOrderBook(2L, 3L, 1L, OrderType.SELL, 5, 1000, OrderStatus.OPEN, LocalDateTime.now());

        Student seller1 = mockStudent();
        seller1.setStdId(2L);
        Student seller2 = mockStudent();
        seller2.setStdId(3L);
        List<StockOrderBook> mockSellOrders = List.of(sellerA, sellerB);

        HoldingStock holdingStock = mockHoldingStock();
        int stockQuantity = holdingStock.getTotalQuantity();

        when(studentMapper.selectStudentByUsernameAndStdName(request.getUsername(), request.getName()))
                .thenReturn(buyer);
        when(stockMapper.selectHoldingStock(1L)).thenReturn(holdingStock);
        when(stockOrderBookMapper.selectAvailableSellOrdersUnderPrice(1L, 1000))
                .thenReturn(mockSellOrders);

        when(studentMapper.selectStudentById(2L)).thenReturn(seller1);
        when(studentMapper.selectStudentById(3L)).thenReturn(seller2);
        HoldingStock seller1HoldingStock = mockHoldingStock();
        seller1HoldingStock.setTotalQuantity(10);
        HoldingStock seller2HoldingStock = mockHoldingStock();
        seller2HoldingStock.setTotalQuantity(10);

        when(stockMapper.selectHoldingStock(eq(2L))).thenReturn(seller1HoldingStock);
        when(stockMapper.selectHoldingStock(eq(3L))).thenReturn(seller2HoldingStock);


        stockService.buyStock(request);

        assertEquals(2500, buyer.getSeed());
        assertEquals(stockQuantity + 10, holdingStock.getTotalQuantity());

        verify(stockOrderBookMapper).updateStockOrderBook(argThat(
                order -> order.getId().equals(1L) && order.getStatus() == OrderStatus.COMPLETED));
        verify(stockOrderBookMapper).updateStockOrderBook(argThat(
                order -> order.getId().equals(2L) && order.getStatus() == OrderStatus.COMPLETED));

        verify(stockOrderBookMapper).insertStockOrderBook(argThat(order ->
                order.getOrderType() == OrderType.BUY && order.getStatus() == OrderStatus.COMPLETED && order.getQuantity() == 10
        ));
        verify(stockOrderBookMapper).insertStockOrderBook(argThat(order ->
                order.getOrderType() == OrderType.BUY && order.getStatus() == OrderStatus.OPEN && order.getQuantity() == 2
        ));
    }


    @DisplayName("주식 매도 요청시 보유한 수량보다 많이 팔고자 할 때 에러발생")
    @Test
    void sellStock_Given_InsufficientQuantity_Then_ThrowException() {
        // given
        StockTradeRequest stockTradeRequest = new StockTradeRequest(1L, "minjoop", "박민주", 50, 1000);

        Student student = mockStudent();
        HoldingStock mockHoldingStock = mockHoldingStock();


        when(studentMapper.selectStudentByUsernameAndStdName(stockTradeRequest.getUsername(), stockTradeRequest.getName()))
                .thenReturn(student);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(mockHoldingStock);

        assertThatThrownBy(() -> stockService.sellStock(stockTradeRequest))
                .isInstanceOf(SsakssakApplicationException.class)
                .hasMessage("잘못된 주식 수량입니다.");
    }

    @DisplayName("주식 매도 요청시 수량이 0이거나 음수이면 에러발생 ")
    @Test
    void sellStock_Given_InsufficientQuantityZeroOrNegative_Then_ThrowException() {
        StockTradeRequest stockTradeRequest = new StockTradeRequest(1L, "minjoop", "박민주", 0,1000);

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
        StockTradeRequest stockTradeRequest = new StockTradeRequest(1L, "minjoop", "박민주", 5, 1000);
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

}