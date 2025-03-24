package com.kb.stock.service;

import com.kb.common.enums.OrderStatus;
import com.kb.common.enums.OrderType;
import com.kb.common.exception.ErrorCode;
import com.kb.common.exception.SsakssakApplicationException;
import com.kb.rateHistory.dto.RateHistoryDTO;
import com.kb.stock.domain.*;
import com.kb.stock.dto.*;
import com.kb.stock.mapper.StockMapper;
import com.kb.stock.mapper.StockOrderBookMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j
@RequiredArgsConstructor
@Service
@PropertySource({"classpath:/application.yml"})
public class StockService {

    private final StockMapper stockMapper;
    private final StudentMapper studentMapper;
    private final StockOrderBookMapper stockOrderBookMapper;

    public List<RateHistory> getRateHistories() {
        return stockMapper.selectRateHistory();
    }

    public List<StockNewsDTO> getStockNewsList() {
        List<StockNews> stockNews = stockMapper.selectStockNews();
        return stockNews.stream().map(StockNewsDTO::from).toList();
    }

    public List<StockTrade> getStockTradeList() {
        return stockMapper.selectStockTradeList();
    }

    @Transactional
    public void buyStock(StockTradeRequest stockTradeRequest) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(stockTradeRequest.getUsername(), stockTradeRequest.getName());
        HoldingStock holdingStock = getHoldingStock(stockTradeRequest.getUsername(), stockTradeRequest.getName());

        int totalPrice = stockTradeRequest.getStockPrice() * stockTradeRequest.getQuantity();
        if(student.getSeed() < totalPrice) {
            throw new SsakssakApplicationException(ErrorCode.INSUFFICIENT_SEED);
        }
        List<StockOrderBook> stockOrderBooks = stockOrderBookMapper.selectAvailableSellOrdersUnderPrice(1L, stockTradeRequest.getStockPrice());
        // TODO : 현재는 주식 하나 뿐이라 1L로 고정
        if(stockOrderBooks.isEmpty()) {
            stockOrderBookMapper.insertStockOrderBook(
                    new StockOrderBookRequest(student.getStdId(), 1L, OrderType.BUY, stockTradeRequest.getQuantity(), stockTradeRequest.getStockPrice(), OrderStatus.OPEN));
        } else {
            int needQuantity = stockTradeRequest.getQuantity();
            for(StockOrderBook stockOrderBook : stockOrderBooks) {
                needQuantity -= stockOrderBook.getQuantity();
                if(needQuantity == 0) {
                    stockOrderBook.setStatus(OrderStatus.COMPLETED);
                    stockOrderBookMapper.updateStockOrderBook(stockOrderBook);
                    break;
                }
            }
            student.minusSeed(totalPrice);
            holdingStock.plusStock(stockTradeRequest.getQuantity());
            stockOrderBookMapper.insertStockOrderBook(
                    new StockOrderBookRequest(student.getStdId(), 1L, OrderType.BUY, stockTradeRequest.getQuantity(), stockTradeRequest.getStockPrice(), OrderStatus.COMPLETED));

            // TODO : 매도자 업데이트 부분

        }

//
//        Student student = Student.of(studentMapper.selectStudentByUsernameAndName
//                (stockTradeRequest.getUsername(), stockTradeRequest.getName()));
//
//        int buyTotalPrice = stockTradeRequest.getQuantity() * stockTradeRequest.getStockPrice();
//
//        if (student.getSeed() < buyTotalPrice) {
//            throw new IllegalArgumentException("보유한 씨드가 부족합니다.");
//        }
//
//        int currentPrice = stockMapper.selectCurrentStockPrice();
//
//        TradeRequest tradeRequest = new TradeRequest();
//        tradeRequest.setStdId(student.getStdId());
//        tradeRequest.setTchId(student.getTchId());
//        tradeRequest.setQuantity(stockTradeRequest.getQuantity());
//        tradeRequest.setStockPrice(stockTradeRequest.getStockPrice());
//
//        int result = stockMapper.insertStockBuy(tradeRequest);
//
//        HoldingStockDTO holdingStockDTO = getHoldingStock(stockTradeRequest.getUsername(), stockTradeRequest.getName());
//
//        int totalInvestment = holdingStockDTO.getTotalInvestment() + tradeRequest.getQuantity() * tradeRequest.getStockPrice();
//        int totalQuantity = holdingStockDTO.getTotalQuantity() + tradeRequest.getQuantity();
//        double averagePrice = (double) totalInvestment / totalQuantity;
//        double currentValue = currentPrice * totalQuantity;
//        double profitLoss = currentValue - totalInvestment;
//        double profitRate = (profitLoss / totalInvestment) * 100;
//
//        holdingStockDTO.setTotalQuantity(totalQuantity);
//        holdingStockDTO.setTotalInvestment(totalInvestment);
//        holdingStockDTO.setAveragePrice(averagePrice);
//        holdingStockDTO.setCurrentValue(currentValue);
//        holdingStockDTO.setProfitLoss(profitLoss);
//        holdingStockDTO.setProfitRate(profitRate);
//
//        studentMapper.updateStudentSeed(student.getStdId(), -buyTotalPrice);
//        int holdingStockResult = stockMapper.updateHoldingStock(holdingStockDTO);
//        if (holdingStockResult != 1 || result != 1) {
//            throw new NoSuchElementException();
//        }
    }

    @Transactional
    public void sellStock(StockTradeRequest stockTradeRequest) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(stockTradeRequest.getUsername(), stockTradeRequest.getName());
        HoldingStock holdingStock = stockMapper.selectHoldingStock(student.getStdId());

        holdingStock.validateSellable(stockTradeRequest.getQuantity());

        StockOrderBookRequest order = StockOrderBookRequest.builder()
                .stdId(student.getStdId())
                .stockId(1L) // 만약 stockId가 1개뿐이면 고정. 아니면 조회 필요
                .orderType(OrderType.SELL)
                .quantity(stockTradeRequest.getQuantity())
                .price(stockTradeRequest.getStockPrice())
                .build();

        stockOrderBookMapper.insertStockOrderBook(order);


//        Student student = Student.of(studentMapper.selectStudentByUsernameAndName
//                (stockTradeRequest.getUsername(), stockTradeRequest.getName()));
//
//        int sellTotalPrice = stockTradeRequest.getQuantity() * stockTradeRequest.getStockPrice();
//        int currentPrice = stockMapper.selectCurrentStockPrice();
//
//        TradeRequest tradeRequest = new TradeRequest();
//        tradeRequest.setStdId(student.getStdId());
//        tradeRequest.setTchId(student.getTchId());
//        tradeRequest.setQuantity(stockTradeRequest.getQuantity());
//        tradeRequest.setStockPrice(stockTradeRequest.getStockPrice());
//
//        int result = stockMapper.insertStockSell(tradeRequest);
//
//        HoldingStockDTO holdingStockDTO = getHoldingStock(stockTradeRequest.getUsername(), stockTradeRequest.getName());
//
//        int totalInvestment = holdingStockDTO.getTotalInvestment() - tradeRequest.getQuantity() * tradeRequest.getStockPrice();
//        int totalQuantity = holdingStockDTO.getTotalQuantity() - tradeRequest.getQuantity();
//        double averagePrice = (double) totalInvestment / totalQuantity;
//        double currentValue = currentPrice * totalQuantity;
//        double profitLoss = currentValue - totalInvestment;
//        double profitRate = profitLoss / totalInvestment * 100;
//
//        holdingStockDTO.setTotalQuantity(totalQuantity);
//        holdingStockDTO.setTotalInvestment(totalInvestment);
//        holdingStockDTO.setAveragePrice(averagePrice);
//        holdingStockDTO.setCurrentValue(currentValue);
//        holdingStockDTO.setProfitLoss(profitLoss);
//        holdingStockDTO.setProfitRate(profitRate);
//
//        studentMapper.updateStudentSeed(student.getStdId(), sellTotalPrice);
//        int holdingStockResult = stockMapper.updateHoldingStock(holdingStockDTO);
//        if (holdingStockResult != 1 || result != 1) {
//            throw new NoSuchElementException();
//        }
    }

    public HoldingStock getHoldingStock(String username, String name) {
        Student student = Student.of(studentMapper.selectStudentByUsernameAndName
                (username, name));
        return stockMapper.selectHoldingStock(student.getStdId());
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
        if(result != 1) {
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
}
