package com.rent;

import com.rent.persistence.model.Users;
import com.rent.persistence.repository.UserRepository;
import com.rent.service.user.UserService;
import com.rent.service.user.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Matija on 29.6.2017..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

    @Mock
    UserRepository userRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testFindByUsername() {

        Users user = new Users();
        user.setUsername("matija");
        when(userRepository.findByUsername("matija")).thenReturn(user);

        Users newUser = userRepository.findByUsername("matija");
        verify(userRepository).findByUsername("matija");
        assertNotNull(newUser.getUsername());

    }

    @Test
    public void testFindByEmail() {

        Users user = new Users();
        user.setEmail("mcerovski@tvz.hr");
        when(userRepository.findByEmail("mcerovski@tvz.hr")).thenReturn(user);

        Users newUser = userRepository.findByEmail("mcerovski@tvz.hr");
        verify(userRepository).findByEmail("mcerovski@tvz.hr");
        assertNotNull(newUser.getEmail());

    }

    @Test
    public void testSaveUser() {

        Users user = new Users();
        user.setUserId(1);
        when(userRepository.save(user)).thenReturn(user);

        Users newUser = userRepository.save(user);
        verify(userRepository).save(user);
        assertNotNull(newUser);

    }

    @Test
    public void testFindByUsernameAndEmail() {

        Users user = new Users();
        user.setUsername("matija");
        user.setEmail("mcerovski@tvz.hr");
        when(userRepository.findByUsernameAndEmail("matija", "mcerovski@tvz.hr")).thenReturn(user);

        Users newUser = userRepository.findByUsernameAndEmail("matija", "mcerovski@tvz.hr");
        verify(userRepository).findByUsernameAndEmail("matija", "mcerovski@tvz.hr");
        assertNotNull(newUser.getUsername());
        assertNotNull(newUser.getEmail());

    }

    @Test
    public void testFindById() {

        Users user = new Users();
        user.setUserId(1);
        when(userRepository.findByUserId(1)).thenReturn(user);

        Users newUser = userRepository.findByUserId(1);
        verify(userRepository).findByUserId(1);
        assertNotNull(newUser.getUserId());

    }

    @Test
    public void testFindAll() {

        List<Users> users = new ArrayList<>();
        Users user = new Users();
        user.setUserId(1);
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);

        List<Users> newUser = userRepository.findAll();
        verify(userRepository).findAll();
        assertNotNull(newUser);

    }


}
