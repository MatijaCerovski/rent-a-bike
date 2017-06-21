package com.rent.service.user;

import com.rent.persistence.model.UserRoles;
import com.rent.persistence.model.Users;
import com.rent.persistence.repository.UserRepository;
import com.rent.service.userrole.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matija on 30.5.2017..
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public Users findByUsername(String username) {
        if(username == null){
            return null;
        }
        return userRepository.findByUsername(username);
    }

    @Override
    public Users findByEmail(String email) {
        if(email == null){
            return null;
        }
        return userRepository.findByEmail(email);
    }

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users findByUsernameAndEmail(String username, String email) {
        if(username == null){
            return null;
        }
        if(email == null){
            return null;
        }
        return  userRepository.findByUsernameAndEmail(username, email);
    }

    @Override
    public Users findById(Integer id)
    {
        if (id == null)
        {
            return null;
        }
        return userRepository.findByUserId(id);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> findAllEmployers() {
        List<Users> allUsers = userRepository.findAll();
        List<Users> employers = new ArrayList<>();
        for (Users user: allUsers) {
            boolean isAdmin = false;
            for (UserRoles userRole: user.getUserRoles()) {
                if (userRole.getRole().equals("ROLE_ADMIN")) {
                    isAdmin = true;
                }
            }
            if (isAdmin) {
                employers.add(user);
            }
        }
        return employers;
    }

    @Override
    public List<Users> findAllOthers() {
        List<Users> allUsers = userRepository.findAll();
        List<Users> otherUsers = new ArrayList<>();
        for (Users user: allUsers) {
            boolean isAdmin = false;
            for (UserRoles userRole: user.getUserRoles()) {
                if (userRole.getRole().equals("ROLE_ADMIN")) {
                    isAdmin = true;
                }
            }
            if (!isAdmin) {
                otherUsers.add(user);
            }
        }
        return otherUsers;
    }

    @Override
    public Users makeEmployer(String username) {
        if (username == null) {
            return null;
        }
        boolean isAdmin = false;
        Users user = userRepository.findByUsername(username);
        List<UserRoles> userRoles = user.getUserRoles();
        for (UserRoles userRole : userRoles) {
            if (userRole.getRole().equals("ROLE_ADMIN")) {
                isAdmin = true;
            }
        }
        if (!isAdmin) {
            userRoles.add(new UserRoles(user, "ROLE_ADMIN"));
        }
        return userRepository.save(user);
    }

    @Override
    public Users letHimGo(String username) {
        if (username == null) {
            return null;
        }
        Users user = userRepository.findByUsername(username);
        int roleId = 0;
        List<UserRoles> userRoles = user.getUserRoles();
        for (int i = 0; i < userRoles.size(); i++) {
            if(userRoles.get(i).getRole().equals("ROLE_ADMIN")) {
                roleId = userRoles.get(i).getUserRoleId();
                userRoles.remove(i);
            }
        }
        user.setUserRoles(userRoles);
        user = userRepository.save(user);

        if(roleId != 0) {
            userRoleService.deleteRole(roleId);
        }
        return user;
    }
}
