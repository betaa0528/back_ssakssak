package com.kb.store.mapper;

import com.kb.store.dto.StoreDTO;

import java.util.List;

public interface StoreMapper {
    List<StoreDTO> selectStore();
}

