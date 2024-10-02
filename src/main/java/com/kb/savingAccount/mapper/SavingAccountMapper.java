package com.kb.savingAccount.mapper;

import com.kb.savingAccount.dto.SavingAccountDTO;
import java.util.List;

public interface SavingAccountMapper {
    List<SavingAccountDTO> selectSavingAccount();

    List<SavingAccountDTO> selectSavingAccountByStudentId(Long stdId);


    void insertSavingAccount(SavingAccountDTO savingAccountDTO);
}