package com.rent.service;

import com.rent.persistence.model.UserRoles;
import com.rent.persistence.model.Users;
import com.rent.persistence.repository.UserRepository;
import com.rent.service.user.UserServiceImpl;
import com.rent.service.userrole.UserRoleService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRoleService userRoleService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByUsername() {
        //Setup
        Users user = new Users();
        user.setUserId(1);
        when(userRepository.findByUsername(anyString())).thenReturn(user);

        //Act
        Users newUser = userService.findByUsername("test");

        //Assert
        verify(userRepository).findByUsername("test");
        assertEquals(newUser, user);
    }

    @Test
    public void findByEmail() {
        //Setup
        Users user = new Users();
        user.setUserId(1);
        when(userRepository.findByEmail(anyString())).thenReturn(user);

        //Act
        Users newUser = userService.findByEmail("test@test");

        //Assert
        verify(userRepository).findByEmail("test@test");
        assertEquals(newUser, user);
    }

    @Test
    public void findById() {
        //Setup
        Users user = new Users();
        user.setUserId(1);
        when(userRepository.findByUserId(anyInt())).thenReturn(user);

        //Act
        Users newUser = userService.findById(1);

        //Assert
        verify(userRepository).findByUserId(1);
        assertEquals(newUser, user);
    }

    @Test
    public void findAll() {
        //Setup
        Users user = new Users();
        user.setUserId(1);
        List<Users> users = new ArrayList<>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);

        //Act
        List<Users> newUsers = userService.findAll();

        //Assert
        verify(userRepository).findAll();
        assertEquals(newUsers, users);
    }

    @Test
    public void findAllEmployers() {
        //Setup
        Users user = new Users();
        UserRoles userRole = new UserRoles();
        userRole.setRole("ROLE_ADMIN");
        List<UserRoles> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);
        user.setUserId(1);
        List<Users> users = new ArrayList<>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);

        //Act
        List<Users> newUsers = userService.findAll();

        //Assert
        verify(userRepository).findAll();
        assertEquals(newUsers, users);
        assertEquals(newUsers.size(), 1);
    }

    @Test
    public void findAllOthers() {
        //Setup
        Users user = new Users();
        UserRoles userRole = new UserRoles();
        userRole.setRole("ROLE_USERS");
        List<UserRoles> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);
        user.setUserId(1);
        List<Users> users = new ArrayList<>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);

        //Act
        List<Users> newUsers = userService.findAll();

        //Assert
        verify(userRepository).findAll();
        assertEquals(newUsers, users);
        assertEquals(newUsers.size(), 1);
    }

    @Test
    public void findByUsernameAndEmail() {
        //Setup
        Users user = new Users();
        user.setUserId(1);
        when(userRepository.findByUsernameAndEmail(anyString(), anyString())).thenReturn(user);

        //Act
        Users newUser = userService.findByUsernameAndEmail("user","test@test");

        //Assert
        verify(userRepository).findByUsernameAndEmail("user","test@test");
        assertEquals(newUser, user);
    }

    @Test
    public void saveUser() {
        //Setup
        Users user = new Users();
        user.setUserId(1);
        when(userRepository.save(any((Users.class)))).thenReturn(user);

        //Act
        Users newUser = userService.saveUser(user);

        //Assert
        verify(userRepository).save(user);
        assertEquals(newUser, user);
    }

    @Test
    public void makeEmployer() {
        //Setup
        Users user = new Users();
        UserRoles userRole = new UserRoles();
        userRole.setRole("ROLE_USER");
        List<UserRoles> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);
        when(userRepository.findByUsername(anyString())).thenReturn(user);
        when(userRepository.save(any((Users.class)))).thenReturn(user);

        //Act
        Users newUser = userService.makeEmployer("test");

        //Assert
        verify(userRepository).findByUsername("test");
        verify(userRepository).save(any(Users.class));
        assertEquals(newUser.getUserRoles().size(), 2);
    }

    @Test
    public void letHimGo() {
        //Setup
        Users user = new Users();
        UserRoles userRole = new UserRoles();
        userRole.setRole("ROLE_ADMIN");
        List<UserRoles> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);
        when(userRepository.findByUsername(anyString())).thenReturn(user);
        when(userRepository.save(any((Users.class)))).thenReturn(user);

        //Act
        Users newUser = userService.letHimGo("test");

        //Assert
        verify(userRepository).findByUsername("test");
        verify(userRepository).save(any(Users.class));
        assertEquals(newUser.getUserRoles().size(), 0);
    }

}
