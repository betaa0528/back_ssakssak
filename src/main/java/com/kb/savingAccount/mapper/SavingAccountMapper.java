package com.kb.savingAccount.mapper;

import com.kb.saving.dto.SavingDTO;
import com.kb.savingAccount.domain.SavingAccount;
import com.kb.savingAccount.dto.SavingAccountDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SavingAccountMapper {
    List<SavingAccountDTO> selectSavingAccount();

    List<SavingAccountDTO> selectSavingAccountByStudentId(Long stdId);

    void insertSavingAccount(SavingAccountDTO savingAccountDTO);

    void insertSavingAccountTeacher(SavingAccountDTO savingAccountDTO);

    SavingAccount selectSavingAccountByAccountId(long id);

    int deleteSavingAccount(long id);
}