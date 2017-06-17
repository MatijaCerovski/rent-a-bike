package com.rent.controller;

import com.rent.form.UserRegistrationForm;
import com.rent.mapper.form.UsersUserRegistrationFormMapper;
import com.rent.persistence.model.Users;
import com.rent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UsersUserRegistrationFormMapper usersUserRegistrationFormMapper;

    @GetMapping
    public String openRegistration(Model model) {

        UserRegistrationForm userRegistrationForm = new UserRegistrationForm();

        model.addAttribute("userRegistrationForm", userRegistrationForm);
        return "registration";
    }

    @PostMapping
    public ModelAndView registracijaKorisnika(@ModelAttribute("userRegistrationForm") @Valid UserRegistrationForm userRegistrationForm,
                                              BindingResult bindingResult){

        Users testUser = userService.findByUsernameAndEmail(userRegistrationForm.getUsername(), userRegistrationForm.getEmail());

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("registration");
            return modelAndView;
        } else if(testUser != null) {
            ModelAndView modelAndView = new ModelAndView("registration");
            modelAndView.addObject("errorMessage", "User already exists");
            return modelAndView;
        } else {
            Users user = usersUserRegistrationFormMapper.mapToEntity(userRegistrationForm);
            userService.saveUser(user);
            return new ModelAndView("redirect:/login");
        }
    }
}
