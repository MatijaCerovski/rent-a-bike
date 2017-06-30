package com.rent;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by Toni on 28-Jun-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testAddOrder() throws Exception {
        this.mockMvc
                .perform(get("/addOrder"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("bikes"))
                .andExpect(model().attributeExists("orderForm"))
                .andExpect(view().name("addOrder"));
    }

    @Test
    public void testReserveBike() throws Exception {
        this.mockMvc
                .perform(get("/reserveBike/{bikeId}", "1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("bikeId"))
                .andExpect(model().attributeExists("orderForm"))
                .andExpect(view().name("reserveBike"));
    }
}