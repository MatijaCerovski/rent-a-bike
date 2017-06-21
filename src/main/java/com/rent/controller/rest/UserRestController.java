package com.rent.controller.rest;

import com.rent.dto.UsersDto;
import com.rent.mapper.dto.UsersUserDtoMapper;
import com.rent.persistence.model.Users;
import com.rent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matija on 21.6.2017..
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    private UsersUserDtoMapper usersUserDtoMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsersDto> getAllUsers(){

        List<UsersDto> usersDtos = new ArrayList<>();
        List<Users> users = userService.findAll();

        for(Users user : users){
            usersDtos.add(usersUserDtoMapper.mapFromEntity(user));
        }
        return  usersDtos;
    }

    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UsersDto getUserByUsername(@PathVariable String username)
    {
        return usersUserDtoMapper.mapFromEntity(userService.findByUsername(username));
    }

    @GetMapping("/email/{email:.+}")
    @ResponseStatus(HttpStatus.OK)
    public UsersDto getUserByEmail(@PathVariable String email)
    {
        return usersUserDtoMapper.mapFromEntity(userService.findByEmail(email));
    }

}
