package com.kb.depositAccount.mapper;

import com.kb.depositAccount.domain.DepositAccount;
import com.kb.depositAccount.dto.DepositAccountDTO;
import com.kb.depositAccount.dto.DepositAccountRequest;
import com.kb.depositAccount.dto.DepositAccountResponse;
import com.kb.depositAccount.dto.DepositMaturity;
import com.kb.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepositAccountMapper {
    int insertDepositAccount(DepositAccountRequest depositAccountRequest);


    List<DepositAccountResponse> selectDepositAccount(long stdId);

    int deleteDepositAccount(long id);

    DepositAccount selectDepositAccountByAccountId(long id);

    List<DepositMaturity> getMaturityDepositList();
    List<DepositMaturity> getMaturityDeposits();
    DepositMaturity getMaturityDeposit();

    void updateDepositAccountStatus(long accountId);
}