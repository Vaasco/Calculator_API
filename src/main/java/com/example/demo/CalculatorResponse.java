package com.example.demo;

import java.math.BigDecimal;

/**
 * A simple response model that encapsulates the result of a calculation.
 */
public class CalculatorResponse {

    private BigDecimal result; // Stores the result of a calculation.

    /**
     * Constructor to initialize the response with a result.
     *
     * @param result The computed result of an arithmetic operation.
     */
    public CalculatorResponse(BigDecimal result) {
        this.result = result;
    }

    /**
     * Getter method to retrieve the result.
     *
     * @return The calculation result.
     */
    public BigDecimal getResult() {
        return result;
    }

    /**
     * Setter method to update the result.
     *
     * @param result The new result value.
     */
    public void setResult(BigDecimal result) {
        this.result = result;
    }
}
