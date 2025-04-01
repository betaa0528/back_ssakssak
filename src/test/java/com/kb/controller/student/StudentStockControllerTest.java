package com.kb.controller.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentStockControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser()
    void getHistories() throws Exception {
        mvc.perform(get("/api/student/stock/data"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser()
    void getNewsList() throws Exception {
        mvc.perform(get("/api/student/stock/news"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser()
    void getStockTradeList() throws Exception {
        mvc.perform(get("/api/student/stock/trade"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void buyStock() {
    }

    @Test
    void sellStock() {
    }

    @Test
    void getHoldingStock() {
    }
}