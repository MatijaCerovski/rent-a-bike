package com.rent.controller;

import com.rent.persistence.model.Shop;
import com.rent.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/")
    public String getHome(){
        //Create shop
        Shop shop = new Shop();
        shop.setShopId(1L); //stupac nije stavljen da se sam setira pa treba rucno stavit id trenutno
        shop.setName("Trgocikl");
        shopService.save(shop);
        shop = new Shop();
        shop.setShopId(2L); //stupac nije stavljen da se sam setira pa treba rucno stavit id trenutno
        shop.setName("Trgocikl");
        shopService.save(shop);
        shop = new Shop();
        shop.setShopId(3L); //stupac nije stavljen da se sam setira pa treba rucno stavit id trenutno
        shop.setName("Trgocikl");
        shop = shopService.save(shop);

        //find shop by id
        Shop shop2 = shopService.findById(shop.getShopId());

        System.out.println("Shop name: " + shop2.getName());

        List<Shop> shopList = shopService.findAllByName(shop.getName());
        System.out.println("Shop list size: " + shopList.size());
        return "index";
    }
}
