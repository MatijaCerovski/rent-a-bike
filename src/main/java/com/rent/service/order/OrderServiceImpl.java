package com.rent.service.order;

import com.rent.persistence.model.Order;
import com.rent.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    @Override
    public Order findById(Integer OrderIdd) {
        if (OrderIdd == null) {
            return null;
        }
        return OrderRepository.findOne(OrderIdd);
    }

    @Override
    public Order save(Order Order) {
        if (Order == null) {
            return null;
        }
        return OrderRepository.save(Order);
    }
    
}
