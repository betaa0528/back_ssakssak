package com.kb.student.service;

import com.kb.dailyCheck.dto.DailyCheckDTO;
import com.kb.depositAccount.mapper.DepositAccountMapper;
import com.kb.salary.mapper.SalaryMapper;
import com.kb.student.dto.*;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j
public class StudentService {

    private final StudentMapper studentMapper;
    private final SalaryMapper salaryMapper;
    private final DepositAccountMapper depositAccountMapper;

    public StudentDTO getStudentProfile(Long studentId) {
        StudentDTO profile = studentMapper.selectStudentProfile(studentId);

        List<DailyCheckDTO> recentAttendance = studentMapper.selectRecentFiveDaysAttendance(studentId);
        profile.setRecentAttendance(recentAttendance);

        return profile;
    }

    public void registerStudent(StudentDTO studentDTO) {
        studentMapper.insertStudent(studentDTO);
    }

    //조은
    public List<SeedRankingDTO> getSeedRanking() {
        return studentMapper.getSeedRanking();
    }

    public List<SeedRankingDTO> getSeedRankingThree() {
        return studentMapper.getSeedRankingThree();
    }

    @Transactional
    public void updateStudent(StudentDTO studentDTO) {
        studentMapper.updateStudent(studentDTO);
    }

    public void saveStudents(List<StudentCsvDTO> Student) {
        for (StudentCsvDTO studentcsvDTO : Student) {
            studentMapper.insertCSVStudent(studentcsvDTO);
        }
    }

    public List<StudentResponse> getAllStudents(String userName) {

        List<StudentResponse> list =  studentMapper.getAllStudentsByTchAccount(userName);
        System.out.println("왜 안뜨는거야 ======> "  + list);

        return list;
    }

    public List<SeedRankingDTO> getStudentSeed() {
        return studentMapper.getStudentSeed();
    }

    // TODO : 성능 개선을 확인하기 위한 코드 삭제 예정
//    @Transactional
//    public void allStudentSalaryUpdate() {
//        List<DepositMaturity> maturityDeposits = depositAccountMapper.getMaturityDeposits();
//        maturityDeposits.forEach(maturity -> {
//            maturity.setStatus('N');
//            depositAccountMapper.updateDepositAccountStatus(maturity.getAccountId());
//            Calculator calculator = new Calculator(new DepositCalculator());
//            int interest = calculator.calculator(maturity.getRate(), maturity.getDepositAmount(), maturity.getDepositPeriod());
//            studentMapper.updateStudentSeed(maturity.getStdId(), interest);
//        });
//    }

}