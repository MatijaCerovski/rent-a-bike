package com.rent.controller;

import com.rent.persistence.model.Shop;
import com.rent.persistence.model.Users;
import com.rent.service.shop.ShopService;
import com.rent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;

    @GetMapping("/")
    public String getHome(){
        //Create shop
        Shop shop = new Shop();
        shop.setName("Trgocikl");
        shopService.save(shop);
        shop = new Shop();
        shop.setName("Trgocik2");
        shopService.save(shop);
        shop = new Shop();
        shop.setName("Trgocik3");
        shop = shopService.save(shop);

        //find shop by id
        Shop shop2 = shopService.findById(shop.getShopId());

        System.out.println("Shop name: " + shop2.getName());

        List<Shop> shopList = shopService.findAllByName(shop.getName());
        System.out.println("Shop list size: " + shopList.size());


        Users user;
        user = userService.findByUsername("matija");

        System.out.println("Dohvacanje usera test  " +user.getEmail());

        return "index";
    }
}
