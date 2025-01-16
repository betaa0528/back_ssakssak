package com.kb.salary.mapper;

import com.kb.salary.dto.Salary;
import com.kb.salary.dto.SalaryBatchRequest;
import com.kb.salary.dto.SalaryHistory;
import com.kb.student.dto.UpdatedStudentSalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryMapper {
    void insertSalary(@Param("baseSalary") int baseSalary,@Param("additionalSalary") int additionalSalary);
    Salary selectSalary();
    List<SalaryBatchRequest> selectSalaryByTchId();
    void insertSalaryHistory(SalaryBatchRequest salaryBatchRequest);


}
