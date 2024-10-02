package com.kb.savingAccount.mapper;

import com.kb.savingAccount.dto.SavingAccountDTO;
import java.util.List;

public interface SavingAccountMapper {
    List<SavingAccountDTO> selectSavingAccount();

    List<SavingAccountDTO> selectSavingAccountByStudentId(Long stdId);  // 학생 ID로 적금 조회


    void insertSavingAccount(SavingAccountDTO savingAccountDTO);
}