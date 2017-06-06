package com.rent.fasada;

import com.rent.dto.UserRegistrationDto;
import com.rent.persistence.model.UserInfo;
import com.rent.persistence.model.UserRoles;
import com.rent.persistence.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matija on 6.6.2017..
 */
@Component
public class UserUserDtoMapper {

    @Autowired
    PasswordEncoder encoder;

    public Users userDtoToUser(UserRegistrationDto userRegistrationDto){

        Users user = new Users();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(encoder.encode(userRegistrationDto.getPassword()));
        user.setEmail(userRegistrationDto.getEmail());
        user.setEnabled(true);

        List<UserRoles> roles = new ArrayList<>();
        UserRoles role = new UserRoles();
        role.setRole("ROLE_USER");
        role.setUser(user);
        roles.add(role);
        user.setUserRoles(roles);

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(userRegistrationDto.getFirstName());
        userInfo.setLastName(userRegistrationDto.getLastName());
        userInfo.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        userInfo.setUser(user);
        user.setUserInfo(userInfo);

        return user;
    }

}
