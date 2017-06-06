package com.rent.controller;

import com.rent.dto.UserRegistrationDto;
import com.rent.fasada.UserUserDtoMapper;
import com.rent.persistence.model.Users;
import com.rent.persistence.repository.UserRepository;
import com.rent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserUserDtoMapper userUserDtoMapper;
    @Autowired
    UserService userService;

    @GetMapping
    public String openRegistration(Model model) {

        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        model.addAttribute("userRegistrationDto", userRegistrationDto);
        return "registration";
    }

    @PostMapping
    public ModelAndView registracijaKorisnika(@ModelAttribute("userRegistrationDto") @Valid UserRegistrationDto userRegistrationDto,
                                              BindingResult bindingResult){

        Users user = userUserDtoMapper.userDtoToUser(userRegistrationDto);
        Users testUser = userService.findByUsernameAndEmail(user.getUsername(), user.getEmail());


        if (bindingResult.hasErrors() || testUser != null) {
            ModelAndView modelAndView = new ModelAndView("registration");
            modelAndView.addObject("errorMessage", "User already exists or wrong credentials!");
            return modelAndView;
        } else {
            userService.saveUser(user);
            return new ModelAndView("redirect:/login");
            // return "redirect:/login";
        }
    }

}
