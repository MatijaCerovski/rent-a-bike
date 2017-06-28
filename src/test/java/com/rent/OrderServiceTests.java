package com.rent;
import com.rent.persistence.model.Order;

import com.rent.service.order.OrderService;
import com.rent.service.order.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
/**
 * Created by Toni on 28-Jun-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderServiceTests {
    @Mock
    private OrderServiceImpl orderService;

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOne()
    {
        Order order = new Order();
        order.setOrderId(1);
        when(orderService.findById(1)).thenReturn(order);

        Order newOrder = orderService.findById(1);

        verify(orderService).findById(1);
    }

    @Test
    public void testFindAll()
    {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOrderId(1);
        orders.add(order);
        when(orderService.findAll()).thenReturn(orders);

        List<Order> newOrders = orderService.findAll();

        verify(orderService).findAll();
        assertNotNull(newOrders);

    }

    @Test
    public void testSave()
    {
        Order order = new Order();
        order.setOrderId(1);
        when(orderService.save(order)).thenReturn(order);

        Order newOrder = orderService.save(order);

        verify(orderService).save(order);
        assertNotNull(newOrder);
    }

    @Test
    public void testDelete()
    {
        Order order = new Order();
        order.setOrderId(1);
        orderService.delete(order);
        verify(orderService).delete(order);

    }

}
