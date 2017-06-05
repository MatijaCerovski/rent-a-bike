package com.rent.service.order;

import com.rent.persistence.model.Order;
import com.rent.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    @Override
    public Order findById(Integer orderId) {
        if (orderId == null) {
            return null;
        }
        return OrderRepository.findOne(orderId);
    }

    @Override
    public Order save(Order Order) {
        if (Order == null) {
            return null;
        }
        return OrderRepository.save(Order);
    }

    @Override
    public List<Order> findAll()
    {
        return OrderRepository.findAll();
    }
    
}
