package com.rent.service.order;

import com.rent.persistence.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findById(Integer orderId);
    Order save(Order order);
    void delete(Order order);


}
