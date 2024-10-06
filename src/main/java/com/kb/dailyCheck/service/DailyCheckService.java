package com.kb.dailyCheck.service;

import com.kb.dailyCheck.dto.DailyCheckDTO;
import com.kb.dailyCheck.mapper.DailyCheckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyCheckService {

    private final DailyCheckMapper dailyCheckMapper;

    public void insertDailyCheck(DailyCheckDTO dailyCheckDTO) {
        dailyCheckMapper.insertDailyCheck(dailyCheckDTO);
    }
}