package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@RestController
public class CalculatorController {

    private final Calculator calculator;
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping(value = Urls.PATH_SUM)
    public ResponseEntity<CalculatorResponse> sum(@RequestParam(name = "a") BigDecimal a,
                                                  @RequestParam(name = "b") BigDecimal b) {
        logger.info("Received sum request: a={}, b={}", a, b);

        BigDecimal result = calculator.sum(a, b);
        logger.info("Sum computed: {} + {} = {}", a, b, result);

        return ResponseEntity.ok(new CalculatorResponse(result));
    }

    @GetMapping(Urls.PATH_SUBTRACT)
    public ResponseEntity<CalculatorResponse> subtract(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        logger.info("Received subtract request: a={}, b={}", a, b);

        BigDecimal result = calculator.subtract(a, b);
        logger.info("Subtraction computed: {} - {} = {}", a, b, result);

        return ResponseEntity.ok(new CalculatorResponse(result));
    }

    @GetMapping(Urls.PATH_MULTIPLY)
    public ResponseEntity<CalculatorResponse> multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        logger.info("Received multiply request: a={}, b={}", a, b);

        BigDecimal result = calculator.multiply(a, b);
        logger.info("Multiplication computed: {} * {} = {}", a, b, result);

        return ResponseEntity.ok(new CalculatorResponse(result));
    }

    @GetMapping(Urls.PATH_DIVIDE)
    public ResponseEntity<CalculatorResponse> divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        logger.info("Received divide request: a={}, b={}", a, b);

        BigDecimal result = calculator.divide(a, b);
        logger.info("Division computed: {} / {} = {}", a, b, result);

        return ResponseEntity.ok(new CalculatorResponse(result));
    }
}
