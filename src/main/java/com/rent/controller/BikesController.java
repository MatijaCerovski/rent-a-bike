package com.rent.controller;

import com.rent.persistence.model.Bike;
import com.rent.service.bike.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dotocan on 3.6.2017..
 */

@Controller
public class BikesController {

    @Autowired
    BikeService bikeService;

    @GetMapping("/bikes")
    public String openBikesList(Model model) {
        model.addAttribute("bikes", bikeService.listAllBikes());
        return "bikes";
    }

    @GetMapping("/add-bike")
    public String openAddBike() {
        return "add_bike";
    }

    @GetMapping("/save-bike")
    public String saveBike() {
        return "add_bike";
    }
}
