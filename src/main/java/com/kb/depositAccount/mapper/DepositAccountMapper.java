package com.kb.depositAccount.mapper;

import com.kb.depositAccount.dto.DepositAccountDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepositAccountMapper {
    void insertDepositAccount(DepositAccountDTO depositAccountDTO);
}