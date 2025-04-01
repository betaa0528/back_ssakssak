package com.kb.stock.service;

import com.kb.common.enums.OrderStatus;
import com.kb.common.enums.OrderType;
import com.kb.common.exception.ErrorCode;
import com.kb.common.exception.SsakssakApplicationException;
import com.kb.stock.domain.*;
import com.kb.stock.dto.*;
import com.kb.stock.mapper.StockMapper;
import com.kb.stock.mapper.StockOrderBookMapper;
import com.kb.student.StudentIdentifiable;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kb.stock.dto.OrderBookDTO.*;

@Log4j
@RequiredArgsConstructor
@Service
@PropertySource({"classpath:/application.yml"})
public class StockService {

    private final StockMapper stockMapper;
    private final StudentMapper studentMapper;
    private final StockOrderBookMapper stockOrderBookMapper;
    private final OrderMatchingService orderMatchingService;

    public List<RateHistoryDTO> getRateHistories() {
        List<RateHistory> rateHistories = stockMapper.selectRateHistory();
        return rateHistories.stream().map(RateHistoryDTO::from).toList();
    }

    public List<StockNewsDTO> getStockNewsList() {
        List<StockNews> stockNews = stockMapper.selectStockNews();
        return stockNews.stream().map(StockNewsDTO::from).toList();
    }

    public List<StockTrade> getStockTradeList() {
        return stockMapper.selectStockTradeList();
    }

    @Transactional
    public void buyStock(StockTradeRequest request) {
        Student student = getStudent(request);
        HoldingStock holdingStock = getHoldingStock(request);

        int totalPrice = request.getStockPrice() * request.getQuantity();
        if (student.getSeed() < totalPrice) {
            throw new SsakssakApplicationException(ErrorCode.INSUFFICIENT_SEED);
        }

        // TODO : 현재는 주식 하나 뿐이라 1L로 고정이지만 수정해야함
        List<StockOrderBook> stockOrderBooks = stockOrderBookMapper.selectAvailableSellOrdersUnderPrice(1L, request.getStockPrice());
        int needQuantity = request.getQuantity();
        needQuantity = orderMatchingService.matchSellOrders(stockOrderBooks, student, holdingStock, needQuantity, request.getStockPrice());

        if(request.getQuantity() - needQuantity > 0) {
            stockOrderBookMapper.insertStockOrderBook(
                new StockOrderBookRequest(
                        student.getStdId(), 1L, OrderType.BUY, request.getQuantity() - needQuantity,
                        request.getStockPrice(), OrderStatus.COMPLETED)
            );
        }

        if (needQuantity > 0) {
            stockOrderBookMapper.insertStockOrderBook(
                    new StockOrderBookRequest(
                            student.getStdId(), 1L, OrderType.BUY, needQuantity,
                            request.getStockPrice(), OrderStatus.OPEN)
            );
        }
        studentMapper.updateStudentSeed(student.getStdId(), student.getSeed());
    }

    private Student getStudent(StudentIdentifiable identifiable) {
        return studentMapper.selectStudentByUsernameAndStdName(identifiable.getUsername(), identifiable.getName());
    }


    @Transactional
    public void sellStock(StockTradeRequest request) {
        Student student = getStudent(request);
        HoldingStock holdingStock = getHoldingStock(request);

        holdingStock.validateSellable(request.getQuantity());

        List<StockOrderBook> buyOrders = stockOrderBookMapper.selectAvailableBuyOrdersOverPrice(1L, request.getStockPrice());
        int remainingQuantity = orderMatchingService.matchBuyOrders(buyOrders, student, holdingStock, request.getQuantity(), request.getStockPrice());

        if (request.getQuantity() - remainingQuantity > 0) {
            stockOrderBookMapper.insertStockOrderBook(
                    new StockOrderBookRequest(
                            student.getStdId(), 1L, OrderType.SELL, request.getQuantity() - remainingQuantity,
                            request.getStockPrice(), OrderStatus.COMPLETED)
            );
        }

        if (remainingQuantity > 0) {
            stockOrderBookMapper.insertStockOrderBook(
                    new StockOrderBookRequest(
                            student.getStdId(), 1L, OrderType.SELL, remainingQuantity,
                            request.getStockPrice(), OrderStatus.OPEN)
            );
        }



        studentMapper.updateStudentSeed(student.getStdId(), student.getSeed());
    }

    public HoldingStock getHoldingStock(StudentIdentifiable identifiable) {
        return stockMapper.selectHoldingStock(identifiable.getStdId());
    }

    public HoldingStock getHoldingStock(String username, String name) {
        return stockMapper.selectHoldingStock(studentMapper.selectStudentByUsernameAndName(username, name).getStdId());
    }

    public List<RateHistoryDTO> getRateHistoryLast5Days() {
        return stockMapper.selectRateHistoryLast5Days();
    }

    public RateHistoryDTO createRateHistory(RateHistoryDTO rateHistory) {
        stockMapper.insertRateHistory(rateHistory);
        return getRateHistoryLast5Days().get(0);
    }

    public void createStockNews(StockNewsRequest request) {
        int result = stockMapper.insertStockNews(request);
        if (result != 1) {
            throw new NoSuchElementException("뉴스 생성 실패");
        }
    }

    public List<ChartDataDTO> getChartDataDTO() {
        return stockMapper.selectChartData();
    }

    public StockChartDTO getStockChartDTO() {
        StockChartDTO stockChartDTO = stockMapper.selectStockChart();
        stockChartDTO.setChartData(getChartDataDTO());
        return stockChartDTO;
    }

    public StockNews getStockNewsById(long id) {
        StockNews stockNews = stockMapper.selectStockNewsById(id);
        return Optional.of(stockNews).orElseThrow(NoSuchElementException::new);
    }

    public StockNews deleteNews(long newsId) {
        StockNews stockNews = getStockNewsById(newsId);
        int result = stockMapper.deleteStockNews(newsId);
        if (result != 1) {
            throw new NoSuchElementException();
        }

        return stockNews;
    }

    public List<StockOrderBook> getSellStockOrderBookList() {
        return stockOrderBookMapper.selectSellStockOrderBookList();
    }

    public OrderBookDTO getOrderBook() {
        List<StockOrderBook> allOrders = stockOrderBookMapper.findAllOpenOrders();

        List<OrderInfo> buyList = allOrders.stream()
                .filter(o -> o.getOrderType().equals(OrderType.BUY))
                .collect(Collectors.groupingBy(StockOrderBook::getPrice, Collectors.summingInt(StockOrderBook::getQuantity)))
                .entrySet().stream()
                .map(e -> new OrderInfo(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(OrderInfo::getPrice).reversed()) // 높은 가격부터
                .toList();

        List<OrderInfo> sellList = allOrders.stream()
                .filter(o -> o.getOrderType().equals(OrderType.SELL))
                .collect(Collectors.groupingBy(StockOrderBook::getPrice, Collectors.summingInt(StockOrderBook::getQuantity)))
                .entrySet().stream()
                .map(e -> new OrderInfo(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(OrderInfo::getPrice)) // 낮은 가격부터
                .toList();

        return new OrderBookDTO(buyList, sellList);
    }
}
