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
 * Created by dotocan on 29.6.2017..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BikesControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testOpenBikesList() throws Exception {
        this.mockMvc
                .perform(get("/bikes"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("bikes"))
                .andExpect(view().name("bikes"));
    }

    @Test
    public void testOpenAddBike() throws Exception {
        this.mockMvc
                .perform(get("/add-bike"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("bikeForm"))
                .andExpect(view().name("add_bike"));
    }

    @Test
    public void testSaveBike() throws Exception {
        this.mockMvc
                .perform(get("bikeForm"))
                .andExpect(redirectedUrl("/bikes"));
    }
}
