package com.rent.service.userrole;

import com.rent.persistence.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public void deleteRole(Integer roleId) {
        userRolesRepository.delete(roleId);
    }
}
