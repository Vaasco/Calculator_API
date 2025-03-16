package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    // Basic Operation Tests

    @Test
    public void testSum() {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("5");
        BigDecimal expected = new BigDecimal("15");

        BigDecimal result = calculator.sum(a, b);

        assertEquals(expected, result, "The sum should be correct");
    }

    @Test
    public void testSubtract() {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("5");
        BigDecimal expected = new BigDecimal("5");

        BigDecimal result = calculator.subtract(a, b);

        assertEquals(expected, result, "The subtraction should be correct");
    }

    @Test
    public void testMultiply() {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("5");
        BigDecimal expected = new BigDecimal("50");

        BigDecimal result = calculator.multiply(a, b);

        assertEquals(expected, result, "The multiplication should be correct");
    }

    @Test
    public void testDivide() {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("2");
        BigDecimal expected = new BigDecimal("5.0000000000");

        BigDecimal result = calculator.divide(a, b);

        assertEquals(expected, result, "The division should be correct");
    }

    @Test
    public void testDivideByZero() {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = BigDecimal.ZERO;

        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b), "Division by zero should throw ArithmeticException");
    }

    // Tests with Decimal Places

    @Test
    public void testSumWithDecimals() {
        BigDecimal a = new BigDecimal("10.25");
        BigDecimal b = new BigDecimal("5.75");
        BigDecimal expected = new BigDecimal("16.00");

        BigDecimal result = calculator.sum(a, b);

        assertEquals(expected, result, "The sum should be correct with decimal values");
    }

    @Test
    public void testSubtractWithDecimals() {
        BigDecimal a = new BigDecimal("10.50");
        BigDecimal b = new BigDecimal("5.30");
        BigDecimal expected = new BigDecimal("5.20");

        BigDecimal result = calculator.subtract(a, b);

        assertEquals(expected, result, "The subtraction should be correct with decimal values");
    }

    @Test
    public void testMultiplyWithDecimals() {
        BigDecimal a = new BigDecimal("10.25");
        BigDecimal b = new BigDecimal("5.30");
        BigDecimal expected = new BigDecimal("54.3250");

        BigDecimal result = calculator.multiply(a, b);

        assertEquals(expected, result, "The multiplication should be correct with decimal values");
    }

    @Test
    public void testDivideWithDecimals() {
        BigDecimal a = new BigDecimal("10.25");
        BigDecimal b = new BigDecimal("2.5");
        BigDecimal expected = new BigDecimal("4.1000000000");

        BigDecimal result = calculator.divide(a, b);

        assertEquals(expected, result, "The division should be correct with decimal values");
    }

    @Test
    public void testDivideWithDecimalResult() {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("3");
        BigDecimal expected = new BigDecimal("3.3333333333");

        BigDecimal result = calculator.divide(a, b);

        assertEquals(expected.setScale(10, BigDecimal.ROUND_HALF_UP), result, "The division should handle decimal places with rounding");
    }
}
