package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.dto.SessionRequestDto;
import kr.co.fastcampus.eatgo.dto.SessionResponseDto;
import kr.co.fastcampus.eatgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    @Autowired
    private UserService userService;

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource) throws URISyntaxException {

        String email = resource.getEmail();
        String password = resource.getPassword();

        User user = userService.authenticate(email,password);
        String accessToken = user.getAccessToken();

        return ResponseEntity.created(new URI("/session"))
                .body(SessionResponseDto.builder()
                        .accessToken(accessToken)
                        .build());
    }
}
