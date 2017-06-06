package com.rent.service.user;

import com.rent.persistence.model.Users;
import com.rent.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Matija on 30.5.2017..
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users findByUsername(String username) {
        if(username == null){
            return null;
        }
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(Users users) {
        userRepository.save(users);
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
}
