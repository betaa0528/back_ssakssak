package com.kb.Scheduled;

import com.kb.salary.dto.Salary;
import com.kb.salary.mapper.SalaryMapper;
import com.kb.student.dto.StudentSalaryDTO;
import com.kb.student.mapper.StudentMapper;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ScheduledTasks {

    private final StudentMapper studentMapper;
    private final SalaryMapper salaryMapper;

    @Scheduled(cron = "0 0 8 * * MON")
    public void giveSalaryToAllStudents() {
        List<StudentSalaryDTO> additionalSalaryStudentList = studentMapper.selectStudentAdditionalSalary();
        Salary salary = salaryMapper.selectSalary();
        studentMapper.updateAllStudentSeed(salary.getBaseSalary());

        for(StudentSalaryDTO dto : additionalSalaryStudentList) {
            studentMapper.updateStudentSeed(dto.getStdId(), salary.getAdditionalSalary());
        }
    }
}
