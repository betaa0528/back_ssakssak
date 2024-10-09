package com.kb.coupon.dto;

import com.kb.alarm.dto.AlarmArgs;
import com.kb.alarm.dto.AlarmType;

public class CouponAlarmArgs implements AlarmArgs {
    private final AlarmType alarmType;
    private final String name;

    public CouponAlarmArgs(AlarmType alarmType, String name) {
        this.alarmType = alarmType;
        this.name = name;
    }

    @Override
    public AlarmType getAlarmType() {
        return alarmType;
    }

    @Override
    public String getProductName() {
        return name;
    }
}
