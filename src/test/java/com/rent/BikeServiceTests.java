package com.rent;

import com.rent.persistence.model.Bike;
import com.rent.persistence.repository.BikeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by dotocan on 30.6.2017..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BikeServiceTests {

    @Mock
    BikeRepository bikeRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Bike> bikes = bikeRepository.findAll();
        assertNotNull(bikes);
    }

    @Test
    public void testFindById() {
        Bike bike = new Bike();
        bike.setBikeId(9);

        when(bikeRepository.findOne(9)).thenReturn(bike);
    }

    /*
    Bike findById(Integer bikeId);

    List<Bike> listAllBikes();

    Bike save(Bike bike);

    void delete(Bike bike);
     */
}