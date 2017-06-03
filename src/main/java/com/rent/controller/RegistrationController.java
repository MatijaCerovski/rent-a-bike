package com.rent.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by Toni on 01-Jun-17.
 */
@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String openRegistration() {
        return "registration";
    }

    @GetMapping("/registration-error")
    public String openErrorRegistration(Model model) {
        model.addAttribute("registrationError", true);
        return "registration";
    }
}
