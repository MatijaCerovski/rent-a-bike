package com.rent.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Matija on 24.5.2017..
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(){
        return "index";
    }
}
