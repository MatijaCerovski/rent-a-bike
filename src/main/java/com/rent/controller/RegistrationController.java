package com.rent.controller;

import com.rent.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Toni on 01-Jun-17.
 */
@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String openRegistration(Model model) {

        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        model.addAttribute("userRegistrationDto", userRegistrationDto);
        return "registration";
    }

    @GetMapping("/registration-error")
    public String openErrorRegistration(Model model) {
        model.addAttribute("registrationError", true);
        return "registration";
    }
}
