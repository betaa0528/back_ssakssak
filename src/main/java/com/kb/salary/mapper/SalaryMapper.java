package com.kb.salary.mapper;

import com.kb.salary.dto.Salary;
import com.kb.salary.dto.SalaryHistory;
import org.apache.ibatis.annotations.Param;

public interface SalaryMapper {
    void insertSalary(@Param("baseSalary") int baseSalary,@Param("additionalSalary") int additionalSalary);
    Salary selectSalary();;


}
