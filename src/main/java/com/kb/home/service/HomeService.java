package com.kb.home.service;

import com.kb.home.mapper.HomeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeMapper homeMapper;

    public int getTreasuryTotal() {
        return homeMapper.getTreasuryTotal();
    }
}