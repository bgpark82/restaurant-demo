package kr.co.fastcampus.eatgo.service;

import kr.co.fastcampus.eatgo.cafe.CafeServiceTest;
import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void getUsers(){
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(User.builder()
                .email("tester@email..com")
                .name("tester")
                .level(1L)
                .build());
        given(userRepository.findAll()).willReturn(mockUsers);

        List<User> users = userService.getUsers();
        assertThat(users.get(0).getName(), is("tester"));
    }

    @Test
    public void addUser(){

        String email = "admin@exmaple.com";
        String name = "Administrator";

        User mockUser = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .build();


        given(userRepository.save(any())).willReturn(mockUser);

        User user = userService.addUser(email, name);
        assertThat(user.getName(), is(name));
    }

    @Test
    public void updateUser(){

        String email = "admin@exmaple.com";
        String name = "Superman";
        Long id = 1004L;
        Long level = 100L;

        User mockUser = User.builder()
                .email(email)
                .name("Administrator")
                .level(1L)
                .build();
        given(userRepository.findById(id)).willReturn(Optional.of(mockUser));

        User user = userService.updateUser(id, email, name, level);

        verify(userRepository).findById(eq(id));

        assertThat(user.getName(), is(name));
        assertThat(user.isAdmin(), is(true));
    }

    @Test
    public void deleteUser(){
        Long id = 1004L;

        User mockUser = User.builder()
                .email("admin@exmaple.com")
                .name("Administrator")
                .level(100L)
                .build();

        given(userRepository.findById(id)).willReturn(Optional.of(mockUser));

        User user = userService.deleteUser(1004L);

        verify(userRepository).findById(1004L);

        assertThat(user.isAdmin(), is(false));
        assertThat(user.isActive(), is(false));
    }
}