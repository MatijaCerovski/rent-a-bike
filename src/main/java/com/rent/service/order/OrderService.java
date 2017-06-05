package com.rent.service.order;

import com.rent.persistence.model.Order;

import java.util.List;

public interface OrderService {

    Order findById(Integer orderId);

    Order save(Order order);

    List<Order> findAll();
}
