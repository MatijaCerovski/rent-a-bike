package com.rent.service.user;

import com.rent.persistence.model.Users;

/**
 * Created by Matija on 30.5.2017..
 */
public interface UserService {

    Users findByUsername(String username);
    void saveUser(Users users);
    Users findByUsernameAndEmail(String username, String email);

}
