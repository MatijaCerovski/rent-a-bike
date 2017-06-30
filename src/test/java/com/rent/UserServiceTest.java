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


}
