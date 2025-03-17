package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * REST controller that handles HTTP requests for arithmetic operations.
 * Provides endpoints for addition, subtraction, multiplication, and division.
 */
@RestController // Marks this class as a REST controller, making it handle HTTP requests.
public class CalculatorController {

    private final Calculator calculator; // Dependency for performing calculations.
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class); // Logger for tracking requests.

    /**
     * Constructor-based dependency injection for the Calculator service.
     *
     * @param calculator The Calculator service to perform arithmetic operations.
     */
    @Autowired // Injects the Calculator dependency through the constructor.
    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Handles HTTP GET requests for addition.
     *
     * @param a First operand as a query parameter.
     * @param b Second operand as a query parameter.
     * @return Response entity containing the sum result.
     */
    @GetMapping(value = Urls.PATH_SUM) // Handles HTTP GET requests for sum operations.
    public ResponseEntity<CalculatorResponse> sum(@RequestParam(name = "a") BigDecimal a,
                                                  @RequestParam(name = "b") BigDecimal b) {
        logger.info("Received sum request: a={}, b={}", a, b);

        BigDecimal result = calculator.sum(a, b);
        logger.info("Sum computed: {} + {} = {}", a, b, result);

        return ResponseEntity.ok(new CalculatorResponse(result)); // Returns the result in a response entity.
    }

    /**
     * Handles HTTP GET requests for subtraction.
     *
     * @param a Minuend (first operand).
     * @param b Subtrahend (second operand).
     * @return Response entity containing the subtraction result.
     */
    @GetMapping(Urls.PATH_SUBTRACT) // Handles HTTP GET requests for subtraction operations.
    public ResponseEntity<CalculatorResponse> subtract(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        logger.info("Received subtract request: a={}, b={}", a, b);

        BigDecimal result = calculator.subtract(a, b);
        logger.info("Subtraction computed: {} - {} = {}", a, b, result);

        return ResponseEntity.ok(new CalculatorResponse(result));
    }

    /**
     * Handles HTTP GET requests for multiplication.
     *
     * @param a First operand.
     * @param b Second operand.
     * @return Response entity containing the multiplication result.
     */
    @GetMapping(Urls.PATH_MULTIPLY) // Handles HTTP GET requests for multiplication operations.
    public ResponseEntity<CalculatorResponse> multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        logger.info("Received multiply request: a={}, b={}", a, b);

        BigDecimal result = calculator.multiply(a, b);
        logger.info("Multiplication computed: {} * {} = {}", a, b, result);

        return ResponseEntity.ok(new CalculatorResponse(result));
    }

    /**
     * Handles HTTP GET requests for division.
     *
     * @param a Dividend (first operand).
     * @param b Divisor (second operand).
     * @return Response entity containing the division result.
     */
    @GetMapping(Urls.PATH_DIVIDE) // Handles HTTP GET requests for division operations.
    public ResponseEntity<CalculatorResponse> divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        logger.info("Received divide request: a={}, b={}", a, b);

        BigDecimal result = calculator.divide(a, b);
        logger.info("Division computed: {} / {} = {}", a, b, result);

        return ResponseEntity.ok(new CalculatorResponse(result));
    }
}
