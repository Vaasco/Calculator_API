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

@Component
public class RequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String requestId = request.getHeader("Request-ID");
        if (requestId == null) {
            requestId = UUID.randomUUID().toString();
        }

        MDC.put("Request-ID", requestId);
        response.setHeader("Request-ID", requestId);

        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("Request-ID");
        }
    }
}
