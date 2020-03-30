package kr.co.fastcampus.eatgo.service;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import kr.co.fastcampus.eatgo.exception.EmailExistedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.constraints.Email;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void registerUser(){
        String email = "tester@example.com";
        String name = "tester";
        String password = "test";

        userService.registerUser(email, name, password);

        verify(userRepository).save(any());
    }

    @Test
    public void registerUserWithExistedEmail(){
        String email = "tester@example.com";
        String name = "tester";
        String password = "test";

        assertThrows(EmailExistedException.class,()-> {
            User mockUser = User.builder().build();
            given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));

            userService.registerUser(email, name, password);

            verify(userRepository, never()).save(any());
            }
        );
    }
}