package com.kb.depositAccount.service;

import com.kb.depositAccount.dto.DepositAccountDTO;
import com.kb.depositAccount.mapper.DepositAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepositAccountService {

    private final DepositAccountMapper depositAccountMapper;

    public void saveDeposit(DepositAccountDTO depositAccountDTO) {
        depositAccountMapper.insertDepositAccount(depositAccountDTO);
    }
}