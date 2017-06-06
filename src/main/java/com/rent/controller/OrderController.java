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
//        Users user;
//        user = userService.findByUsername("akrizmani");
//        System.out.println("User username: " + user.getUsername());
//        Shop shop2 = shopService.findById(new Long(29));
//        System.out.println("Shop name: " + shop2.getName());
//
////        Bike bike = new Bike();
////        bike.setMaker("test");
////        bike.setModel("test");
////        bike.setPrice(BigDecimal.valueOf(456.5));
////        bike.setShop(shop2);
////        bikeService.save(bike);
//        Bike bike = bikeService.findById(3);
//        System.out.println("Bike Maker: " + bike.getMaker());
//
//
//        Order order = new Order();
//        order.setUser(user);
//        order.setBike(bike);
//        LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Montreal" ) );
//        order.setStartDate(todayLocalDate);
//        order.setEndDate(todayLocalDate);
//        order.setOrderStatus(OrderStatus.Pending);
//        System.out.println("Start date: " + order.getStartDate());
//        System.out.println("End date: " + order.getEndDate());
//        orderService.save(order);



        Order order = orderService.findById(1);
        System.out.println("Order");
        List<Order> orderList = orderService.findAll();
        System.out.println("Order List");
        model.addAttribute("orders",orderList);
        System.out.println("Model");
        return "orderList";
    }
}
