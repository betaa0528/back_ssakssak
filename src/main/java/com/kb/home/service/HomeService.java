package com.kb.home.service;

import com.kb.home.mapper.HomeMapper;
import com.kb.student.dto.StudentSalaryDTO;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeMapper homeMapper;
    private final StudentMapper studentMapper;


    public int getTreasuryTotal() {
        return homeMapper.getTreasuryTotal();
    }


//    @Transactional
//    public void paySalaryToStudents(StudentSalaryDTO studentSalaryDTO) {
//        long treasuryId = 1; // 국고 테이블의 기본 treasury_id
//
//
//        studentMapper.updateAllStudentSeed(studentSalaryDTO.getSeed());
//
//        int studentCount = studentMapper.getStudentCount();
//
//        int balance = getTreasuryTotal();
//        int totalSalary = studentSalaryDTO.getSeed() * studentCount;
//        if (balance < totalSalary) {
//            throw new IllegalArgumentException("국고에 남아있는 잔액이 부족합니다. 주급 지급이 불가능합니다.");
//        }
//
//        homeMapper.decreaseTreasuryBalance(totalSalary, treasuryId);
//
//        homeMapper.recordSalaryTransaction(totalSalary, "주급 지급 (학생 수: " + studentCount + ")");
//    }
}