package com.rent.service.order;

import com.rent.persistence.model.Order;

public interface OrderService {

    Order findById(Integer orderId);

    Order save(Order order);
}
