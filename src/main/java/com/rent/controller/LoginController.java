package com.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Matija on 30.5.2017..
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String openLogin() {
        return "login";
    }

    @GetMapping("/login-error")
    public String openErrorLogin(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
