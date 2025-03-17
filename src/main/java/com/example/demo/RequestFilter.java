package com.example.demo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * A filter to add a unique "Request-ID" to each incoming request and response.
 * This helps to trace requests through the system and is useful for logging and debugging.
 */
@Component // Marks this class as a Spring component, making it available for dependency injection.
public class RequestFilter extends OncePerRequestFilter {

    /**
     * This method is invoked for every HTTP request. It assigns a unique "Request-ID" to each request and sets it in the MDC.
     * The request ID is either taken from the request header or generated as a new UUID if not present.
     *
     * @param request The incoming HTTP request.
     * @param response The outgoing HTTP response.
     * @param chain The filter chain to pass the request and response to the next filter or resource.
     * @throws ServletException If a servlet exception occurs.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Attempt to retrieve "Request-ID" from the request header. If absent, generate a new UUID.
        String requestId = request.getHeader("Request-ID");
        if (requestId == null) {
            requestId = UUID.randomUUID().toString();
        }

        // Store the "Request-ID" in MDC for logging purposes.
        MDC.put("Request-ID", requestId);

        // Set the "Request-ID" header in the response.
        response.setHeader("Request-ID", requestId);

        try {
            // Proceed with the filter chain to handle the request.
            chain.doFilter(request, response);
        } finally {
            // Remove the "Request-ID" from MDC after the request has been processed.
            MDC.remove("Request-ID");
        }
    }
}
