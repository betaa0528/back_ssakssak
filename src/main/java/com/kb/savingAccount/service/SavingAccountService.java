package com.kb.savingAccount.service;

import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingDTO;
import com.kb.saving.mapper.SavingMapper;
import com.kb.savingAccount.dto.SavingAccountDTO;
import com.kb.savingAccount.mapper.SavingAccountMapper;
import com.kb.savingAccount.mapper.SavingAccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class SavingAccountService {

    private final SavingAccountMapper mapper;


    public List<SavingAccountDTO> getSavingAccountsByStudentId(Long studentId) {
        return mapper.selectSavingAccountByStudentId(studentId);
    };

    public SavingAccountDTO createSavingAccount(SavingAccountDTO SavingAccountDTO) {
        mapper.insertSavingAccount(SavingAccountDTO);
        return SavingAccountDTO;
    }
}