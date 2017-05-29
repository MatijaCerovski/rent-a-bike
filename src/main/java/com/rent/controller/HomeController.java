package com.rent.controller;

import com.rent.model.Shop;
import com.rent.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Matija on 24.5.2017..
 */
@Controller
public class HomeController {

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("/")
    public String getHome(){
        Shop shop = shopRepository.getOne(1L);
        System.out.println(shop.getName());
        return "index";
    }
}
