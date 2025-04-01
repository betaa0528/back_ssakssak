package com.kb.common.utils;

public class Calculator {

    private final InterestCalculator interestCalculator;

    public Calculator(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    public int calculator(double rate, int amount, int period) {
        return this.interestCalculator.calculate(rate, amount, period);
    }
}
