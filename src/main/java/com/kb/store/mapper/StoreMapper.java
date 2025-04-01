package com.kb.store.mapper;

import com.kb.store.dto.StoreDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreMapper {
    void insertStore(StoreDTO storeDTO);

    List<StoreDTO> getStoreList();

}