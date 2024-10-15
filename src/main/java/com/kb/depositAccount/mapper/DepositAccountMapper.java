package com.kb.depositAccount.mapper;

import com.kb.depositAccount.domain.DepositAccount;
import com.kb.depositAccount.dto.DepositAccountDTO;
import com.kb.depositAccount.dto.DepositAccountRequest;
import com.kb.depositAccount.dto.DepositAccountResponse;
import com.kb.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepositAccountMapper {
    int insertDepositAccount(DepositAccountRequest depositAccountRequest);


    List<DepositAccountResponse> selectDepositAccount(long stdId);

    int deleteDepositAccount(long id);

    DepositAccount selectDepositAccountByAccountId(long id);
}