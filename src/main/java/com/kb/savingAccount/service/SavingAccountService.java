package com.kb.savingAccount.service;

import com.kb.alarm.dto.AlarmArgs;
import com.kb.alarm.dto.AlarmType;
import com.kb.alarm.service.AlarmService;
import com.kb.member.dto.Member;
import com.kb.savingAccount.domain.SavingAccount;
import com.kb.savingAccount.dto.SavingAccountDTO;
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
@PropertySource({"classpath:/application.yml"})
public class SavingAccountService {

    private final SavingAccountMapper mapper;
    private final StudentMapper studentMapper;
    private final AlarmService alarmService;

    public List<SavingAccountDTO> getSavingAccountsByStudentId(Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        return mapper.selectSavingAccountByStudentId(student.getStdId());
    };

    @Transactional
    public SavingAccountDTO createSavingAccount(SavingAccountDTO savingAccountDTO, Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        savingAccountDTO.setStdId(student.getStdId());
        savingAccountDTO.setTchId(student.getTchId());
        mapper.insertSavingAccount(savingAccountDTO);
        AlarmArgs alarmArgs = new AlarmArgs(AlarmType.SAVING_ACCOUNT_JOIN, savingAccountDTO.getSavingName(), student.getStdName());
        alarmService.sendAlarm(student.getStdId(), alarmArgs, savingAccountDTO.getSavingId());
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