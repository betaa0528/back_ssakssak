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


//    // 주급 지급 로직: 학생들에게 씨드를 추가하고 국고에서 차감
//    @Transactional
//    public void paySalaryToStudents(StudentSalaryDTO studentSalaryDTO) {
//        long treasuryId = 100; // 국고 테이블의 기본 treasury_id
//
//        // 1. 모든 학생들에게 주급 지급 (씨드 추가)
//        studentMapper.updateAllStudentSeed(studentSalaryDTO.getSeed());
//
//        // 2. 국고 잔액에서 해당 금액 차감
//        homeMapper.decreaseTreasuryBalance(studentSalaryDTO.getSeed(), treasuryId);
//
//        // 3. 국고 거래 내역에 주급 지급 기록
//        homeMapper.recordSalaryTransaction(studentSalaryDTO.getSeed(), "주급 지급");
//    }

    @Transactional
    public void paySalaryToStudents(StudentSalaryDTO studentSalaryDTO) {
        long treasuryId = 1; // 국고 테이블의 기본 treasury_id

        // 1. 모든 학생들에게 주급 지급 (씨드 추가)
        studentMapper.updateAllStudentSeed(studentSalaryDTO.getSeed());

        // 2. 학생 수 조회
        int studentCount = studentMapper.getStudentCount();

        // 3. 총 지급 금액 = 주급 금액 * 학생 수
        int totalSalary = studentSalaryDTO.getSeed() * studentCount;

        // 4. 국고 잔액에서 총 지급 금액 차감
        homeMapper.decreaseTreasuryBalance(totalSalary, treasuryId);

        // 5. 국고 거래 내역에 주급 지급 기록
        homeMapper.recordSalaryTransaction(totalSalary, "주급 지급 (학생 수: " + studentCount + ")");
    }
}