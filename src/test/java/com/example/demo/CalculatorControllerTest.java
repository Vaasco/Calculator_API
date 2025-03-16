package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSum() throws Exception {
        mockMvc.perform(get(Urls.PATH_SUM)
                        .param("a", "5")
                        .param("b", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("15"));
    }

    @Test
    public void testSubtract() throws Exception {
        mockMvc.perform(get(Urls.PATH_SUBTRACT)
                        .param("a", "10")
                        .param("b", "5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("5"));
    }

    @Test
    public void testMultiply() throws Exception {
        mockMvc.perform(get(Urls.PATH_MULTIPLY)
                        .param("a", "5")
                        .param("b", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("50"));
    }

    @Test
    public void testDivide() throws Exception {
        mockMvc.perform(get(Urls.PATH_DIVIDE)
                        .param("a", "10")
                        .param("b", "5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("2.0"));
    }

    @Test
    public void testDivideByZero() throws Exception {
        mockMvc.perform(get(Urls.PATH_DIVIDE)
                        .param("a", "10")
                        .param("b", "0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Arithmetic exception occurred: Can't divide by zero"));
    }
}
