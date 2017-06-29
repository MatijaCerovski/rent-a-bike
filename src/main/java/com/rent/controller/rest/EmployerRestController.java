package com.rent.controller.rest;

import com.rent.dto.EmployersWrapperDto;
import com.rent.dto.UsersDto;
import com.rent.mapper.dto.UsersUserDtoMapper;
import com.rent.persistence.model.Users;
import com.rent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employers")
public class EmployerRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UsersUserDtoMapper usersUserDtoMapper;

    @GetMapping
    public EmployersWrapperDto employersList() {

        List<Users> employers = userService.findAllEmployers();
        List<Users> otherUsers = userService.findAllOthers();

        List<UsersDto> employersList = new ArrayList<>();
        List<UsersDto> othersList = new ArrayList<>();

        employersList.addAll(employers.stream().map(employer -> usersUserDtoMapper.mapFromEntity(employer)).collect(Collectors.toList()));

        for (Users other : otherUsers) {
            othersList.add(usersUserDtoMapper.mapFromEntity(other));
        }

        return new EmployersWrapperDto(employersList, othersList);
    }

    @GetMapping("/makeEmployer/{username}")
    public UsersDto makeEmployer(@PathVariable String username) {
        return usersUserDtoMapper.mapFromEntity(userService.makeEmployer(username));
    }

    @GetMapping("/letHimGo/{username}")
    public UsersDto letHimGo(@PathVariable String username) {
        return usersUserDtoMapper.mapFromEntity(userService.letHimGo(username));
    }

}
