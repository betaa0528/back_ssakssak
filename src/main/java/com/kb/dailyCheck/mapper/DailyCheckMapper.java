package com.kb.dailyCheck.mapper;

import com.kb.dailyCheck.dto.DailyCheckDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailyCheckMapper {

    @Insert("INSERT INTO Daily_check (std_id, tch_id, check_date, isCheck) " +
            "VALUES (#{stdId}, #{tchId}, NOW(), #{isCheck})")
    int insertDailyCheck(DailyCheckDTO dailyCheckDTO);
}