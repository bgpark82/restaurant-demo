package kr.co.fastcampus.eatgo.service;

import kr.co.fastcampus.eatgo.domain.User;

import kr.co.fastcampus.eatgo.domain.UserRepository;
import kr.co.fastcampus.eatgo.exception.EmailExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String name, String password) {

        Optional<User> existed = userRepository.findByEmail(email);
        if(existed.isPresent()){
            throw  new EmailExistedException(email);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        User user = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .password(encodedPassword)
                .build();

        return userRepository.save(user);

    }
}
