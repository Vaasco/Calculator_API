package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global error handler for the application.
 * This class catches and handles exceptions that occur during request processing.
 */
@ControllerAdvice // Marks this class as a global exception handler.
public class ErrorHandler {

    // Logger for tracking errors and debugging issues.
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    /**
     * Handles ArithmeticException, such as division by zero.
     * Logs the error and returns a 400 Bad Request response with a meaningful message.
     *
     * @param ex The caught ArithmeticException.
     * @return ResponseEntity with an error message and HTTP status 400.
     */
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex) {
        String message = "Arithmetic exception occurred: Can't divide by zero";
        logger.error(message); // Logs the error for debugging purposes.
        return ResponseEntity.badRequest().body(message); // Returns a client-friendly error response.
    }

    /**
     * Global fallback handler for all unexpected exceptions.
     * Logs the error and returns a generic bad request response.
     *
     * @param ex The caught Exception.
     * @return ResponseEntity with a general error message and HTTP status 400.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        logger.error("Invalid parameter format: Expected a valid number."); // Logs the error message.
        return ResponseEntity.badRequest().body("Invalid parameter: Must be a valid number."); // Returns a user-friendly response.
    }
}
