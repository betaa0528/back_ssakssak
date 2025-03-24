package com.kb.stock.mapper;

import com.kb.stock.domain.StockOrderBook;
import com.kb.stock.dto.StockOrderBookRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface StockOrderBookMapper {
    int insertStockOrderBook(StockOrderBookRequest orderBook);
    StockOrderBook selectStockOrderBookById(Long id);

    List<StockOrderBook> selectSellStockOrderBookList();

    List<StockOrderBook> selectAvailableSellOrdersUnderPrice(@PathVariable("stockId")Long stock_id ,@PathVariable("price") int price);

    void updateStockOrderBook(StockOrderBook stockOrderBook);
}
