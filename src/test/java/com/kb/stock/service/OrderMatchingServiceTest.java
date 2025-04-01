package com.kb.stock.service;

import com.kb.common.enums.OrderStatus;
import com.kb.common.enums.OrderType;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderMatchingServiceTest {

    @Mock
    private StudentMapper studentMapper;
    @Mock
    private StockOrderBookMapper stockOrderBookMapper;
    @Mock
    private StockMapper stockMapper;

    @InjectMocks
    private OrderMatchingService orderMatchingService;

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
                .seed(10000)
                .build();
    }

    private HoldingStock mockHoldingStock() {
        return HoldingStock.builder()
                .stdId(1L)
                .totalQuantity(0)
                .totalInvestment(10000)
                .averagePrice(0.0)
                .currentValue(0.0)
                .profitLoss(0.0)
                .profitRate(0.0)
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

    @DisplayName("매수자의 씨드는 매칭된 수량 * 가격만큼 감소해야 한다")
    @Test
    void buyerSeedShouldDecreaseAccordingToMatchedQuantity() {
        Student buyer = mockStudent();
        buyer.setSeed(10000);

        HoldingStock buyerStock = mockHoldingStock();
        StockTradeRequest request = mockStockTradeRequest();
        request.setQuantity(10);

        StockOrderBook stockOrderBook = new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 10, 1000, OrderStatus.OPEN, LocalDateTime.now());

        List<StockOrderBook> orders = List.of(stockOrderBook);

        Student seller = mockStudent();
        HoldingStock sellerStock = mockHoldingStock();

        when(studentMapper.selectStudentById(anyLong())).thenReturn(seller);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(sellerStock);

        orderMatchingService.matchSellOrders(orders, buyer, buyerStock, request.getQuantity(), request.getStockPrice());


        assertEquals(0, buyer.getSeed());
    }

    @DisplayName("매수자의 보유 주식 수량이 매칭된 수량만큼 증가해야 한다")
    @Test
    void buyerHoldingStockShouldIncrease() {
        Student buyer = mockStudent();
        buyer.setSeed(10000);


        StockTradeRequest request = mockStockTradeRequest();
        HoldingStock buyerStock = mockHoldingStock();
        buyerStock.setTotalQuantity(0);

        StockOrderBook stockOrderBook = new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 10, 1000, OrderStatus.OPEN, LocalDateTime.now());

        List<StockOrderBook> orders = List.of(stockOrderBook);

        Student seller = mockStudent();
        HoldingStock sellerStock = mockHoldingStock();

        when(studentMapper.selectStudentById(anyLong())).thenReturn(seller);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(sellerStock);

        orderMatchingService.matchSellOrders(orders, buyer, buyerStock, request.getQuantity(), request.getStockPrice());


        assertEquals(10, buyerStock.getTotalQuantity());

    }

    @DisplayName("판매자는 매도한 수량 * 가격만큼 씨드가 증가하고 보유 주식은 감소한다")
    @Test
    void sellerGetsPaidAndStockDecreases() {
        Student buyer = mockStudent();
        buyer.setSeed(10000);

        StockTradeRequest request = mockStockTradeRequest();
        HoldingStock buyerStock = mockHoldingStock();
        buyerStock.setTotalQuantity(0);

        StockOrderBook stockOrderBook = new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 5, 1000, OrderStatus.OPEN, LocalDateTime.now());

        List<StockOrderBook> orders = List.of(stockOrderBook);

        Student seller = mockStudent();
        seller.setSeed(0);
        HoldingStock sellerStock = mockHoldingStock();
        sellerStock.setTotalQuantity(10);

        when(studentMapper.selectStudentById(anyLong())).thenReturn(seller);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(sellerStock);

        orderMatchingService.matchSellOrders(orders, buyer, buyerStock, 10, request.getStockPrice());

        assertEquals(5000, seller.getSeed());
        assertEquals(5, sellerStock.getTotalQuantity());
    }

    @DisplayName("매칭된 수량이 주문 수량과 동일하면 COMPLETED 상태가 된다")
    @Test
    void orderShouldBeCompletedIfFullyMatched() {
        StockOrderBook sellOrder = new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 5, 1000, OrderStatus.OPEN, LocalDateTime.now());
        List<StockOrderBook> sellOrders = List.of(sellOrder);

        StockTradeRequest request = mockStockTradeRequest();
        Student buyer = mockStudent();
        HoldingStock buyerStock = mockHoldingStock();

        Student seller = mockStudent(); seller.setStdId(2L);
        HoldingStock sellerStock = mockHoldingStock();

        when(studentMapper.selectStudentById(anyLong())).thenReturn(seller);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(sellerStock);

        orderMatchingService.matchSellOrders(sellOrders, buyer, buyerStock, 5, request.getStockPrice());

        assertEquals(OrderStatus.COMPLETED, sellOrder.getStatus());
    }

    @DisplayName("일부만 매칭된 경우, 주문 수량은 줄어들고 상태는 OPEN 상태를 유지한다")
    @Test
    void orderShouldRemainOpenIfPartiallyMatched() {
        StockOrderBook sellOrder = new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 10, 1000, OrderStatus.OPEN, LocalDateTime.now());
        List<StockOrderBook> sellOrders = List.of(sellOrder);

        Student buyer = mockStudent();
        HoldingStock buyerStock = mockHoldingStock();

        StockTradeRequest request = mockStockTradeRequest();

        Student seller = mockStudent(); seller.setStdId(2L);
        HoldingStock sellerStock = mockHoldingStock();

        when(studentMapper.selectStudentById(anyLong())).thenReturn(seller);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(sellerStock);

        orderMatchingService.matchSellOrders(sellOrders, buyer, buyerStock, 5, request.getStockPrice());

        assertEquals(OrderStatus.OPEN, sellOrder.getStatus());
        assertEquals(5, sellOrder.getQuantity());
        verify(stockOrderBookMapper, times(1)).updateStockOrderBook(sellOrder);
    }

    @DisplayName("매도 주문 수량보다 매수 희망 수량이 많을 경우, 남은 수량이 리턴된다")
    @Test
    void returnRemainingQuantityWhenNotFullyMatched() {
        StockOrderBook sellOrder = new StockOrderBook(1L, 2L, 1L, OrderType.SELL, 10, 1000, OrderStatus.OPEN, LocalDateTime.now());
        List<StockOrderBook> sellOrders = List.of(sellOrder);

        StockTradeRequest request = mockStockTradeRequest();
        request.setQuantity(20);
        Student buyer = mockStudent();
        HoldingStock buyerStock = mockHoldingStock();

        Student seller = mockStudent(); seller.setStdId(2L);
        HoldingStock sellerStock = mockHoldingStock();

        when(studentMapper.selectStudentById(anyLong())).thenReturn(seller);
        when(stockMapper.selectHoldingStock(anyLong())).thenReturn(sellerStock);

        int result = orderMatchingService.matchSellOrders(sellOrders, buyer, buyerStock, request.getQuantity(), request.getStockPrice());

        assertEquals(10, result);
    }


    @Test
    @DisplayName("충분한 매수 주문이 있을 때 전체 매칭된다")
    void fullMatchSellOrder() {
        // given
        // - seller, sellerStock
        // - buyer들, buyerStock들
        // - 매수 주문 2개

        Student seller = mockStudent();
        seller.setStdId(1L);
        HoldingStock sellerStock = mockHoldingStock();
        sellerStock.setStdId(1L);

        StockTradeRequest request = mockStockTradeRequest();
        request.setQuantity(15);
        request.setStockPrice(900);
        StockOrderBook sellOrder1 = new StockOrderBook(1L, 1L, 1L, OrderType.SELL, 15, 900, OrderStatus.OPEN, LocalDateTime.now());
        seller.setSeed(0);
        sellerStock.setTotalQuantity(15);

        StockOrderBook buyOrder1 = new StockOrderBook(10L, 10L, 1L, OrderType.BUY, 5, 1000, OrderStatus.OPEN, LocalDateTime.now());
        StockOrderBook buyOrder2 = new StockOrderBook(11L, 11L, 1L, OrderType.BUY, 5, 1000, OrderStatus.OPEN, LocalDateTime.now());
        StockOrderBook buyOrder3 = new StockOrderBook(12L, 12L, 1L, OrderType.BUY, 5, 1000, OrderStatus.OPEN, LocalDateTime.now());

        List<StockOrderBook> buyOrders = List.of(buyOrder1, buyOrder2, buyOrder3);
        Student buyer1 = mockStudent();
        Student buyer2 = mockStudent();
        Student buyer3 = mockStudent();
        buyer1.setStdId(10L);
        buyer2.setStdId(11L);
        buyer3.setStdId(12L);
        buyer1.setSeed(5000);
        buyer2.setSeed(6000);
        buyer3.setSeed(7000);
        HoldingStock buyerStock1 = mockHoldingStock();
        HoldingStock buyerStock2 = mockHoldingStock();
        HoldingStock buyerStock3 = mockHoldingStock();
        buyerStock1.setStdId(10L);
        buyerStock2.setStdId(11L);
        buyerStock3.setStdId(12L);
        buyerStock1.setTotalQuantity(0);
        buyerStock2.setTotalQuantity(1);
        buyerStock3.setTotalQuantity(2);
        // when
        // - matchBuyOrders 호출
        when(studentMapper.selectStudentById(10L)).thenReturn(buyer1);
        when(studentMapper.selectStudentById(11L)).thenReturn(buyer2);
        when(studentMapper.selectStudentById(12L)).thenReturn(buyer3);

        when(stockMapper.selectHoldingStock(10L)).thenReturn(buyerStock1);
        when(stockMapper.selectHoldingStock(11L)).thenReturn(buyerStock2);
        when(stockMapper.selectHoldingStock(12L)).thenReturn(buyerStock3);

        orderMatchingService.matchBuyOrders(buyOrders, seller, sellerStock, request.getQuantity(), request.getStockPrice());
        // then
        // - seller 씨드 증가
        // - seller 주식 감소
        // - buyer 씨드 감소
        // - buyer 주식 증가
        // - 매물 상태 COMPLETED 확인
        assertEquals(13500, seller.getSeed());
        assertEquals(0, sellerStock.getTotalQuantity());
        assertEquals(500, buyer1.getSeed());
        assertEquals(1500, buyer2.getSeed());
        assertEquals(2500, buyer3.getSeed());
        assertEquals(5, buyerStock1.getTotalQuantity());
        assertEquals(6, buyerStock2.getTotalQuantity());
        assertEquals(7, buyerStock3.getTotalQuantity());
        assertEquals(OrderStatus.COMPLETED, buyOrder1.getStatus());
        assertEquals(OrderStatus.COMPLETED, buyOrder2.getStatus());
        assertEquals(OrderStatus.COMPLETED, buyOrder3.getStatus());


    }

    @Test
    @DisplayName("일부만 체결되고 나머지는 미체결로 남는다")
    void partialMatchSellOrder() {
        // given
        Student seller = mockStudent();
        seller.setStdId(1L);
        seller.setSeed(0);

        StockTradeRequest request = mockStockTradeRequest();
        request.setQuantity(8);
        request.setStockPrice(900);

        HoldingStock sellerStock = mockHoldingStock();
        sellerStock.setStdId(1L);
        sellerStock.setTotalQuantity(8);

        StockOrderBook sellorder = new StockOrderBook(1L, 1L, 1L, OrderType.SELL, request.getQuantity(), request.getStockPrice(), OrderStatus.OPEN, LocalDateTime.now());

        Student buyer1 = mockStudent();
        buyer1.setStdId(2L);
        buyer1.setSeed(10000);

        HoldingStock buyerStock1 = mockHoldingStock();
        buyerStock1.setStdId(2L);
        buyerStock1.setTotalQuantity(5);

        Student buyer2 = mockStudent();
        buyer2.setStdId(3L);
        buyer2.setSeed(10000);

        HoldingStock buyerStock2 = mockHoldingStock();
        buyerStock2.setStdId(3L);
        buyerStock2.setTotalQuantity(5);


        StockOrderBook buyorderA = new StockOrderBook(2L, 2L, 1L, OrderType.BUY, 5, 900, OrderStatus.OPEN, LocalDateTime.now());
        StockOrderBook buyorderB = new StockOrderBook(2L, 3L, 1L, OrderType.BUY, 5, 900, OrderStatus.OPEN, LocalDateTime.now());

        // when

        when(studentMapper.selectStudentById(2L)).thenReturn(buyer1);
        when(stockMapper.selectHoldingStock(2L)).thenReturn(buyerStock1);
        when(studentMapper.selectStudentById(3L)).thenReturn(buyer2);
        when(stockMapper.selectHoldingStock(3L)).thenReturn(buyerStock2);

        orderMatchingService.matchBuyOrders(List.of(buyorderA, buyorderB), seller, sellerStock, request.getQuantity(), request.getStockPrice());

        // then
        // - seller 씨드 일부 증가
        // - remainQuantity 확인
        // - order 상태 일부 COMPLETED, 일부 OPEN

        assertEquals(7200, seller.getSeed());
        assertEquals(0, sellerStock.getTotalQuantity());
        assertEquals(10, buyerStock1.getTotalQuantity());
        assertEquals(8, buyerStock2.getTotalQuantity());
    }

    @Test
    @DisplayName("체결 가능한 매수 주문이 없으면 미체결된다")
    void noMatchingBuyOrder() {
        // given
        // 매수 주문 없음
        Student seller = mockStudent();
        seller.setStdId(1L);
        seller.setSeed(0);

        StockTradeRequest request = mockStockTradeRequest();
        request.setQuantity(15);
        request.setStockPrice(900);

        HoldingStock sellerStock = mockHoldingStock();
        sellerStock.setStdId(1L);
        sellerStock.setTotalQuantity(15);
        StockOrderBook sellorder = new StockOrderBook(1L, 1L, 1L, OrderType.SELL, request.getQuantity(), request.getStockPrice(), OrderStatus.OPEN, LocalDateTime.now());

        int remainQuantity = orderMatchingService.matchBuyOrders(List.of(), seller, sellerStock, request.getQuantity(), request.getStockPrice());

        // when
        // then
        // - remainQuantity == originalQuantity
        // - 상태 변화 없음

        assertEquals(0, seller.getSeed());
        assertEquals(request.getQuantity(), remainQuantity);
        assertEquals(OrderStatus.OPEN, sellorder.getStatus());
    }

    @Test
    @DisplayName("여러 매수 주문에 대해 순차적으로 체결된다")
    void matchMultipleBuyOrdersInOrder() {
        // given
        // 매수 주문 3개
        // when
        // then
        // - 체결 순서대로 처리됐는지 확인
    }


}