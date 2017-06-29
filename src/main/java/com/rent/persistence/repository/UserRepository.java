package com.rent.persistence.repository;

import com.rent.persistence.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Matija on 30.5.2017..
 */
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

    Users findByUsernameAndEmail(String username, String email);

    Users findByUserId(Integer id);

    Users findByEmail(String email);

}
