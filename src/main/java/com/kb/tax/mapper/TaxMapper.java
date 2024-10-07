package com.kb.tax.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

@Mapper
public interface TaxMapper {
    int getTaxTotalForLastWeek(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}