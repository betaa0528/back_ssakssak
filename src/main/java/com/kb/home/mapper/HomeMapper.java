package com.kb.home.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HomeMapper {
    int getTreasuryTotal();
}