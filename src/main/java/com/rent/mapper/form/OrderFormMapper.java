package com.rent.mapper.form;


import com.rent.form.OrderForm;
import com.rent.persistence.model.Order;
import com.rent.persistence.model.OrderStatus;
import com.rent.persistence.model.Users;
import com.rent.service.bike.BikeService;
import com.rent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Toni on 07-Jun-17.
 */

@Component
public class OrderFormMapper {
    @Autowired
    UserService userService;

    @Autowired
    BikeService bikeService;

    public Order mapToEntity(OrderForm orderForm) {
        Order order = new Order();

        order.setOrderStatus(OrderStatus.pending);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(orderForm.getStartDate(), formatter);
        order.setStartDate(startDate);
        LocalDate endDate = LocalDate.parse(orderForm.getEndDate(), formatter);
        order.setEndDate(endDate);

        order.setBike(bikeService.findById(orderForm.getBikeId()));

        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = userService.findByUsername(((User) auth).getUsername());

        order.setUser(user);
        return order;
    }
}
