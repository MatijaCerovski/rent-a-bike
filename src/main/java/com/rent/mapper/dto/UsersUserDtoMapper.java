package com.rent.mapper.dto;

import com.rent.dto.UserInfoDto;
import com.rent.dto.UsersDto;
import com.rent.persistence.model.UserInfo;
import com.rent.persistence.model.UserRoles;
import com.rent.persistence.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersUserDtoMapper {

    public UsersDto mapFromEntity(Users user) {

        String username = user.getUsername();
        boolean enabled = user.isEnabled();
        String email = user.getEmail();
        List<String> roles = new ArrayList<>();
        roles.addAll(user.getUserRoles().stream().map(UserRoles::getRole).collect(Collectors.toList()));
        UserInfo userInfo = user.getUserInfo();
        UserInfoDto userInfoDto = new UserInfoDto(userInfo.getFirstName(), userInfo.getLastName(), userInfo.getPhoneNumber());

        return new UsersDto(username, enabled, email, roles, userInfoDto);
    }
}
