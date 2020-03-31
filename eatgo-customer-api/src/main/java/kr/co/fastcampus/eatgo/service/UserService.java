package kr.co.fastcampus.eatgo.service;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import kr.co.fastcampus.eatgo.exception.EmailExistedException;
import kr.co.fastcampus.eatgo.exception.EmailNotExistedException;
import kr.co.fastcampus.eatgo.exception.PasswordWrongException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String email, String name, String password) {

        Optional<User> existed = userRepository.findByEmail(email);
        if(existed.isPresent()){
            throw  new EmailExistedException(email);
        }

        //BCryptPasswordEncoder passwordEncoder = passwordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        User user = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .password(encodedPassword)
                .build();

        return userRepository.save(user);

    }


    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new EmailNotExistedException(email));

        //BCryptPasswordEncoder passwordEncoder = passwordEncoder();
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new PasswordWrongException();
        };
        return user;
    }

//    private BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
