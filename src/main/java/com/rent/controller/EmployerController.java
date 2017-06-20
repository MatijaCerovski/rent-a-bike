package com.rent.controller;

import com.rent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class EmployerController {

    @Autowired
    private UserService userService;

    @GetMapping("/employers")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String employersList(Model model) {

        model.addAttribute("employers", userService.findAllEmployers());
        model.addAttribute("otherUsers", userService.findAllOthers());

        return "employers";
    }

    @GetMapping("/makeEmployer/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String makeEmployer(@PathVariable String username, Model model)
    {
        userService.makeEmployer(username);
        return employersList(model);
    }

    @GetMapping("/letHimGo/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String letHimGo(@PathVariable String username, Model model)
    {
        userService.letHimGo(username);
        return employersList(model);
    }
}
