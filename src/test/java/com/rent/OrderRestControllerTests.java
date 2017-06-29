package com.rent;

import com.rent.service.order.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Toni on 28-Jun-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderRestControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderService orderservice;

    @Test
    public void test_get_all() throws Exception {

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_find_by_id() throws Exception {

        mockMvc.perform(get("/api/orders/{id}", "19"))
                .andExpect(status().isOk());
    }

}
