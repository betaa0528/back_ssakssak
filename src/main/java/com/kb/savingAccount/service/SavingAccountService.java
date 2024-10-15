package com.kb.savingAccount.service;

import com.kb.member.dto.Member;
import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingDTO;
import com.kb.saving.mapper.SavingMapper;
import com.kb.savingAccount.domain.SavingAccount;
import com.kb.savingAccount.dto.SavingAccountDTO;
import com.kb.savingAccount.mapper.SavingAccountMapper;
import com.kb.savingAccount.mapper.SavingAccountMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class SavingAccountService {

    private final SavingAccountMapper mapper;
    private final StudentMapper studentMapper;


    public List<SavingAccountDTO> getSavingAccountsByStudentId(Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        return mapper.selectSavingAccountByStudentId(student.getStdId());
    };

    public SavingAccountDTO createSavingAccount(SavingAccountDTO savingAccountDTO, Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        savingAccountDTO.setStdId(student.getStdId());
        savingAccountDTO.setTchId(student.getTchId());
        mapper.insertSavingAccount(savingAccountDTO);
        return savingAccountDTO;
    }

    @Transactional
    public void cancelSavingAccount(long id) {
        SavingAccount savingAccount = mapper.selectSavingAccountByAccountId(id);
        studentMapper.updateStudentSeed(savingAccount.getStdId(), savingAccount.getTotalAmount());
        int result = mapper.deleteSavingAccount(id);
        if(result != 1) {
            throw new NoSuchElementException();
        }
    }
}