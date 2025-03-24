package com.kb.common.utils;

public class SavingCalculator implements InterestCalculator {
    @Override
    public int calculate(double rate, int amount, int period) {
        double total = 0;
        rate /= 100;
        while(period --> 0) {
            total += amount * Math.pow(1 + rate, period);
        }

        return (int) Math.floor(total);
    }
}
