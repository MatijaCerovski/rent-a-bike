package com.rent.controller;

import com.rent.dto.UserRegistrationDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Toni on 01-Jun-17.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping
    public String openRegistration(Model model) {

        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        model.addAttribute("userRegistrationDto", userRegistrationDto);
        return "registration";
    }

    @PostMapping
    public ModelAndView registracijaKorisnika(@ModelAttribute("userRegistrationDto") @Valid UserRegistrationDto userRegistrationDto,
                                              BindingResult bindingResult){


        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/registration");
        } else {
            return new ModelAndView("redirect:/login");
            // return "redirect:/login";
        }
    }

}
