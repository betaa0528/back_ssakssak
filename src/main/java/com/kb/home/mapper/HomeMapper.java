package com.kb.home.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface HomeMapper {
    int getTreasuryTotal();

    // 국고의 잔액에서 총 지급 금액 차감
    void decreaseTreasuryBalance(@Param("amount") int amount, @Param("treasuryId") long treasuryId);

    // 국고 거래 내역 추가 (주급 지급 기록)

    void recordSalaryTransaction(@Param("amount") int amount, @Param("description") String description);
}