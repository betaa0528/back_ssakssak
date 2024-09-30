package com.kb.store.service;

import com.kb.store.dto.StoreDTO;
import com.kb.store.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class StoreService {

    private final StoreMapper mapper;

    public List<StoreDTO> getAllStores() {
        List<StoreDTO> stores = mapper.selectStore();
        log.info(stores);
        return stores;
    }


}
