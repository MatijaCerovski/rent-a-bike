package com.rent.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Matija on 30.5.2017..
 */

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String openProfile(Model model, Principal principal) {


        return "profile";
    }


}
