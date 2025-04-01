package com.kb.stock.service;

import com.kb.common.enums.OrderStatus;
import com.kb.common.enums.OrderType;
import com.kb.stock.domain.HoldingStock;
import com.kb.stock.domain.StockOrderBook;
import com.kb.stock.dto.StockOrderBookRequest;
import com.kb.stock.mapper.StockMapper;
import com.kb.stock.mapper.StockOrderBookMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderMatchingService {

    private final StudentMapper studentMapper;
    private final StockOrderBookMapper stockOrderBookMapper;
    private final StockMapper stockMapper;

    public int matchSellOrders(List<StockOrderBook> orders, Student buyer, HoldingStock buyerStock, int needQuantity, int sellPrice) {
        for (StockOrderBook stockOrderBook : orders) {
            int available = stockOrderBook.getQuantity();

            if (needQuantity <= 0) break;

            int matched = Math.min(needQuantity, available);

            buyer.minusSeed(matched * stockOrderBook.getPrice());
            buyerStock.plusStock(matched);

            if (matched == available) {
                stockOrderBook.setStatus(OrderStatus.COMPLETED);
            } else {
                stockOrderBook.setQuantity(available - matched);
            }

            updateSellerAfterMatch(stockOrderBook, matched, sellPrice);
            needQuantity -= matched;
        }

        return needQuantity;
    }

    public int matchBuyOrders(List<StockOrderBook> buyOrders, Student seller, HoldingStock sellerStock, int quantity, int sellPrice) {
        for (StockOrderBook order : buyOrders) {
            int available = order.getQuantity();

            if (quantity <= 0) break;

            int matched = Math.min(quantity, available);

            seller.plusSeed(matched * sellPrice);
            sellerStock.minusStock(matched);

            if (matched == available) {
                order.setStatus(OrderStatus.COMPLETED);
            } else {
                order.setQuantity(available - matched);
            }

            updateBuyerAfterMatch(order, matched, sellPrice);
            persistSellerState(seller, sellerStock, order);

            quantity -= matched;
        }

        return quantity;
    }

    private void updateBuyerAfterMatch(StockOrderBook order, int matchedQuantity, int price) {
        Student buyer = studentMapper.selectStudentById(order.getStdId());
        HoldingStock buyerStock = stockMapper.selectHoldingStock(buyer.getStdId());

        buyer.minusSeed(price * matchedQuantity);
        buyerStock.plusStock(matchedQuantity);

        persistSellerState(buyer, buyerStock, order);
    }


    private void updateSellerDomainState(Student seller, HoldingStock sellerStock, int matchedQuantity, int price) {
        seller.plusSeed(price * matchedQuantity);
        sellerStock.setTotalQuantity(sellerStock.getTotalQuantity() - matchedQuantity);
    }

    private void persistSellerState(Student seller, HoldingStock sellerStock, StockOrderBook order) {
        stockOrderBookMapper.updateStockOrderBook(order);
        studentMapper.updateStudentSeed(seller.getStdId(), seller.getSeed());
        stockMapper.updateHoldingStock(sellerStock);
    }

    private void updateSellerAfterMatch(StockOrderBook order, int matchedQuantity, int price) {
        Student seller = studentMapper.selectStudentById(order.getStdId());
        HoldingStock sellerHoldingStock = stockMapper.selectHoldingStock(seller.getStdId());

        updateSellerDomainState(seller, sellerHoldingStock, matchedQuantity, price);
        persistSellerState(seller, sellerHoldingStock, order);
    }

}
