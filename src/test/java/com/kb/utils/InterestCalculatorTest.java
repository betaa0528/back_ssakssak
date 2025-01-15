package com.kb.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterestCalculatorTest {

    @Test
    public void 예금이자계산기() {
        InterestCalculator d = new DepositCalculator();
        Calculator calculator = new Calculator(d);
        double calculate = calculator.calculator(5, 400, 4);
        assertEquals(480, calculate);
    }

    @Test
    public void 적금이자계산기() {
        Calculator calculator = new Calculator(new SavingCalculator());
        double calculate = calculator.calculator(5, 100, 4);
        assertEquals(431, calculate, 0.1);
    }
}
