package com.rent.controller;

import com.rent.form.OrderForm;
import com.rent.mapper.form.OrderFormMapper;
import com.rent.persistence.model.Bike;
import com.rent.persistence.model.Order;
import com.rent.service.bike.BikeService;
import com.rent.service.order.OrderService;
import com.rent.validation.OrderFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Toni on 04-Jun-17.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private OrderFormMapper orderFormMapper;

    @Autowired
    private OrderFormValidator orderFormValidator;

    @GetMapping("/orders")
    //@PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String orderList(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @GetMapping("/addOrder")
    //@PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String addOrder(Model model) {
        OrderForm orderForm = new OrderForm();
        List<Bike> bikes = bikeService.listAllBikes();
        model.addAttribute("bikes", bikes);
        model.addAttribute("orderForm", orderForm);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal().toString());
        return "addOrder";
    }

    @PostMapping("/addOrder")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView saveOrder(@ModelAttribute("orderForm") @Valid OrderForm orderForm, BindingResult bindingResult) {

        orderFormValidator.validate(orderForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("addOrder");
        } else {
            Order newOrder = orderFormMapper.mapToEntity(orderForm);
            orderService.save(newOrder);
            return new ModelAndView("redirect:/orders");
        }
    }

    @GetMapping("/reserveBike/{bikeId}")
    //@PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String reserveBike(Model model, @PathVariable String bikeId) {
        OrderForm orderForm = new OrderForm();
        orderForm.setBikeId(Integer.parseInt(bikeId));
        List<Bike> bikes = bikeService.listAllBikes();
        model.addAttribute("bikeId", bikeId);
        model.addAttribute("orderForm", orderForm);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal().toString());
        return "reserveBike";
    }

    @PostMapping("/reserveBike")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public ModelAndView saveOrderWithBike(@ModelAttribute("orderForm") @Valid OrderForm orderForm, BindingResult bindingResult) {

        orderFormValidator.validate(orderForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("reserveBike");
        } else {
            Order newOrder = orderFormMapper.mapToEntity(orderForm);
            orderService.save(newOrder);
            return new ModelAndView("redirect:/orders");
        }
    }
}
