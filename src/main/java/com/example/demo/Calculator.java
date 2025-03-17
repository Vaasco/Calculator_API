package com.example.demo;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Service class that provides basic arithmetic operations using BigDecimal.
 * This class is a Spring-managed component, allowing it to be injected into other parts of the application.
 */
@Service // Marks this class as a Spring service component, making it available for dependency injection.
public class Calculator {

    /**
     * Adds two BigDecimal numbers and returns the result.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The sum of a and b.
     */
    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    /**
     * Subtracts one BigDecimal number from another.
     *
     * @param a The number to subtract from.
     * @param b The number to be subtracted.
     * @return The result of a - b.
     */
    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    /**
     * Multiplies two BigDecimal numbers and returns the result.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The product of a and b.
     */
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    /**
     * Divides one BigDecimal number by another, with error handling for division by zero.
     * Uses HALF_UP rounding mode and limits the result to 10 decimal places.
     *
     * @param a The numerator.
     * @param b The denominator.
     * @return The quotient of a / b.
     * @throws ArithmeticException if b is zero.
     */
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Division by zero is not allowed."); // Throws an exception if denominator is zero.
        }
        return a.divide(b, 10, RoundingMode.HALF_UP); // Performs division with 10 decimal places and HALF_UP rounding mode.
    }
}
