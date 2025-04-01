package com.kb.deposit.mapper;

import com.kb.deposit.domain.Deposit;
import com.kb.deposit.dto.DepositDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DepositMapper {
    List<DepositDTO> getDepositList();

    void deleteDeposit(long id);

    void insertDeposit(Deposit deposit);
}