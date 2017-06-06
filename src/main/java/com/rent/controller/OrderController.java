package com.rent.controller;

import com.rent.persistence.model.*;
import com.rent.service.bike.BikeService;
import com.rent.service.order.OrderService;
import com.rent.service.shop.ShopService;
import com.rent.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * Created by Toni on 04-Jun-17.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private ShopService shopService;

    @GetMapping("/orderList")
    public String orderList(Model model)
    {
        List<Order> orders = orderService.findAll();
        Order order = orderService.findById(1);
        System.out.println("Order status: " + order.getOrderStatus());
        model.addAttribute("orders",orders);
        return "orderList";
    }
}
