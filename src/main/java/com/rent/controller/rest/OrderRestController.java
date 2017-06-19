package com.rent.controller.rest;

import com.rent.dto.OrderDto;
import com.rent.persistence.model.Bike;
import com.rent.persistence.model.Order;
import com.rent.persistence.model.Users;
import com.rent.service.bike.BikeService;
import com.rent.service.order.OrderService;
import com.rent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toni on 19-Jun-17.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @Autowired
    BikeService bikeService;

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAllOrders()
    {
        List<OrderDto> orderDtos = new ArrayList<OrderDto>();
        List<Order> orders = orderService.findAll();

        for(Order order : orders)
        {
            OrderDto orderDto = new OrderDto();
            Bike bike = order.getBike();
            Users user = order.getUser();
            orderDto.setBikeId(bike.getBikeId());
            orderDto.setUserId(user.getUserId());
            orderDto.setOrderId(order.getOrderId());
            orderDto.setStatus(order.getOrderStatus());
            orderDto.setStartDate(order.getStartDate().toString());
            orderDto.setEndDate(order.getEndDate().toString());

            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getOrder(@PathVariable Integer id)
    {
        OrderDto orderDto = new OrderDto();
        Order order = orderService.findById(id);


        Bike bike = order.getBike();
        Users user = order.getUser();
        orderDto.setBikeId(bike.getBikeId());
        orderDto.setUserId(user.getUserId());
        orderDto.setOrderId(order.getOrderId());
        orderDto.setStatus(order.getOrderStatus());
        orderDto.setStartDate(order.getStartDate().toString());
        orderDto.setEndDate(order.getEndDate().toString());

        return orderDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public boolean save(@RequestBody OrderDto orderDto){
        Bike bike = bikeService.findById(orderDto.getBikeId());
        Users user = userService.findById(orderDto.getUserId());

        Order order = new Order();
        order.setUser(user);
        order.setBike(bike);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(orderDto.getStartDate(), formatter);
        order.setStartDate(startDate);
        LocalDate endDate = LocalDate.parse(orderDto.getEndDate(), formatter);
        order.setEndDate(endDate);

        order.setOrderStatus(orderDto.getStatus());
        orderService.save(order);
        return true;
    }

//    @PutMapping()
//    public boolean update (@RequestBody OrderDto orderDto)
//    {
//        Bike bike = bikeService.findById(orderDto.getBikeId());
//        Users user = userService.findById(orderDto.getUserId());
//
//        Order order = new Order();
//        order.setUser(user);
//        order.setBike(bike);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate startDate = LocalDate.parse(orderDto.getStartDate(), formatter);
//        order.setStartDate(startDate);
//        LocalDate endDate = LocalDate.parse(orderDto.getEndDate(), formatter);
//        order.setEndDate(endDate);
//
//        order.setOrderStatus(orderDto.getStatus());
//        orderService.update(order);
//        return true;
//    }


    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id)
    {
        orderService.delete(orderService.findById(id));
    }

}
