package com.rent.mapper.form;

import com.rent.form.UserRegistrationForm;
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
public class UsersUserRegistrationFormMapper {

    @Autowired
    PasswordEncoder encoder;

    public Users mapToEntity(UserRegistrationForm userRegistrationForm) {

        Users user = new Users();
        user.setUsername(userRegistrationForm.getUsername());
        user.setPassword(encoder.encode(userRegistrationForm.getPassword()));
        user.setEmail(userRegistrationForm.getEmail());
        user.setEnabled(true);

        List<UserRoles> roles = new ArrayList<>();
        UserRoles role = new UserRoles();
        role.setRole("ROLE_USER");
        role.setUser(user);
        roles.add(role);
        user.setUserRoles(roles);

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(userRegistrationForm.getFirstName());
        userInfo.setLastName(userRegistrationForm.getLastName());
        userInfo.setPhoneNumber(userRegistrationForm.getPhoneNumber());
        userInfo.setUser(user);
        user.setUserInfo(userInfo);

        return user;
    }

}