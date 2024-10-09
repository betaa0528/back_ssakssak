package com.kb.deposit.service;

import com.kb.deposit.dto.DepositDTO;
import com.kb.deposit.mapper.DepositMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositService {

    private final DepositMapper depositMapper;

    public List<DepositDTO> getDepositList() {
        return depositMapper.getDepositList();
    }
}