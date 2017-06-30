package com.rent;

import com.rent.persistence.model.Order;
import com.rent.persistence.repository.OrderRepository;
import com.rent.service.order.OrderService;
import com.rent.service.order.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Toni on 28-Jun-17.
 */
public class OrderServiceTests {

    @InjectMocks
    private OrderServiceImpl orderService; //Klasa koja se testira

    @Mock
    private OrderRepository orderRepository; //Dependency koji treba mockat

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findById() {
        //Setup
        Order order = new Order();
        order.setOrderId(1);
        when(orderRepository.findOne(1)).thenReturn(order); //mockanje sto ce vratit metoda unutar one koju testiramo

        //Act
        Order newOrder = orderService.findById(1); //Poziv metode koju testiramo

        //Assert //tu provjeravamo je li metoda koju testiramo napravila ono što smo očekivali,
        verify(orderRepository).findOne(1); // dal je pozvala ono što je trebala
        assertEquals(newOrder, order); // jel vratila rezultat koji je trebala
    }

    @Test
    public void testFindAll() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOrderId(1);
        orders.add(order);
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> newOrders = orderService.findAll();

        verify(orderRepository).findAll();
        assertNotNull(newOrders);
        assertEquals(newOrders,orders);

    }

    @Test
    public void testSave() {
        Order order = new Order();
        order.setOrderId(1);
        when(orderRepository.save(order)).thenReturn(order);

        Order newOrder = orderService.save(order);

        verify(orderRepository).save(order);
        assertNotNull(newOrder);
    }

    @Test
    public void testDelete() {
        Order order = new Order();
        order.setOrderId(1);

        when(orderRepository.save(order)).thenReturn(order);

        orderService.delete(order);

        verify(orderRepository).delete(order);
    }

}
