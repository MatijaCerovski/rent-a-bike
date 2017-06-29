package com.rent.service.order;

import com.rent.persistence.model.Order;
import com.rent.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Integer orderId) {
        if (orderId == null) {
            return null;
        }
        return orderRepository.findOne(orderId);
    }

    @Override
    public Order save(Order order) {
        if (order == null) {
            return null;
        }
        return orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        if (order == null) {

        }
        orderRepository.delete(order);
    }

}
