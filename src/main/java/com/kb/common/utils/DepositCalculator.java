package com.kb.common.utils;

public class DepositCalculator implements InterestCalculator {
    @Override
    public int calculate(double rate, int amount, int period) {
        return (int) Math.floor(amount + amount * rate/100 * period);
    }
}
