package com.kb.alarm.dto;

public class AlarmArgsImpl implements AlarmArgs{
    private final AlarmType alarmType;
    private final String productName;

    public AlarmArgsImpl(AlarmType alarmType, String name) {
        this.alarmType = alarmType;
        this.productName = name;
    }

    @Override
    public AlarmType getAlarmType() {
        return alarmType;
    }

    @Override
    public String getProductName() {
        return productName;
    }
}
