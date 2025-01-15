package com.kb.depositAccount.service;

import com.kb.depositAccount.domain.DepositAccount;
import com.kb.depositAccount.dto.DepositAccountDTO;
import com.kb.depositAccount.dto.DepositAccountRequest;
import com.kb.depositAccount.dto.DepositAccountResponse;
import com.kb.depositAccount.dto.DepositMaturity;
import com.kb.depositAccount.mapper.DepositAccountMapper;
import com.kb.member.dto.Member;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepositAccountService {

    private final DepositAccountMapper depositAccountMapper;
    private final StudentMapper studentMapper;

    public List<DepositAccountResponse> getDepositAccountById(Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        return depositAccountMapper.selectDepositAccount(student.getStdId());
    }

    @Transactional
    public void subscribeDepositAccount(DepositAccountDTO depositAccountDTO, Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        if(student.getSeed() < depositAccountDTO.getDepositAmount()) {
            throw new IllegalArgumentException("예금입금액보다 보유씨드가 적습니다.");
        }
        studentMapper.updateStudentSeed(student.getStdId(), -depositAccountDTO.getDepositAmount());
        DepositAccountRequest depositAccountRequest = new DepositAccountRequest(
                student.getStdId(),
                student.getTchId(),
                depositAccountDTO.getDepositId(),
                depositAccountDTO.getRate(),
                depositAccountDTO.getDepositAmount(),
                depositAccountDTO.getStartDate(),
                depositAccountDTO.getEndDate()
        );
        int result = depositAccountMapper.insertDepositAccount(depositAccountRequest);
        if(result != 1) {
            throw new IllegalArgumentException("예금 가입에 실패했습니다.");
        }
    }

    @Transactional
    public void cancelDepositAccount(long id) {
        DepositAccount depositAccount = depositAccountMapper.selectDepositAccountByAccountId(id);
        studentMapper.updateStudentSeed(depositAccount.getStdId(), depositAccount.getDepositAmount());
        int result = depositAccountMapper.deleteDepositAccount(id);
        if(result != 1) {
            throw new NoSuchElementException();
        }
    }

    // TODO : TEST용도 였으므로 지울것
    public DepositMaturity getMaturity() {
        return depositAccountMapper.getMaturityDeposit();
    }
}