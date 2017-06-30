package com.rent;

import com.rent.controller.rest.BikesRestController;
import com.rent.dto.BikeDto;
import com.rent.service.bike.BikeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by dotocan on 29.6.2017..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BikesRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BikesRestController bikesRestController;

    @Mock
    private BikeService bikeService;

    @Test
    public void testGetAllBikes() throws Exception {
        mockMvc.perform(get("/api/bikes"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveBike() throws Exception {
        BikeDto bikeDto = new BikeDto();
        bikeDto.setMaker("bike");
        bikeDto.setModel("bike");
        bikeDto.setPrice(BigDecimal.valueOf(50.00));

        String json = "{ \"maker\":\"bike\", \"model\":\"bike\", \"price\":50 }";

        mockMvc.perform(post("/api/bikes", json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}