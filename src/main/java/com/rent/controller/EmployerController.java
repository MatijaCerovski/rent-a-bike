package com.rent.controller;

import com.rent.persistence.model.UserRoles;
import com.rent.persistence.model.Users;
import com.rent.service.user.UserService;
import com.rent.service.userrole.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Controller
public class EmployerController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/employers")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String orderList(Model model) {
        List<Users> allUsers = userService.findAll();
        List<Users> employers = new ArrayList<>();
        List<Users> otherUsers = new ArrayList<>();
        for (Users user: allUsers) {
            boolean isAdmin = false;
            for (UserRoles userRole: user.getUserRoles()) {
                if (userRole.getRole().equals("ROLE_ADMIN")) {
                    isAdmin = true;
                }
            }
            if (isAdmin) {
                employers.add(user);
            } else {
                otherUsers.add(user);
            }
        }

        model.addAttribute("employers", employers);
        model.addAttribute("otherUsers", otherUsers);
        return "employers";
    }

    @GetMapping("/makeEmployer/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String makeEmployer(@PathVariable String username, Model model)
    {
        Users user = userService.findByUsername(username);
        List<UserRoles> userRoles = user.getUserRoles();
        userRoles.add(new UserRoles(user, "ROLE_ADMIN"));
        userService.saveUser(user);
        return orderList(model);
    }

    @GetMapping("/letHimGo/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String letHimGo(@PathVariable String username, Model model)
    {
        Users user = userService.findByUsername(username);
        int roleId = 0;
        List<UserRoles> userRoles = user.getUserRoles();
        for (int i = 0; i < userRoles.size(); i++) {
            if(userRoles.get(i).getRole().equals("ROLE_ADMIN")) {
                roleId = userRoles.get(i).getUserRoleId();
                userRoles.remove(i);
            }
        }
        user.setUserRoles(userRoles);
        userService.saveUser(user);

        if(roleId != 0) {
            userRoleService.deleteRole(roleId);
        }
        return orderList(model);
    }
}
