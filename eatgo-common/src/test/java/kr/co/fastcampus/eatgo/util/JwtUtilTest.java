package kr.co.fastcampus.eatgo.util;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    @Test
    public void createToken(){
        String secret = "123456789123456789123456789123456789";
        JwtUtil jwtUtil = new JwtUtil(secret);
        String token = jwtUtil.createToken(1004L,"John");

        assertThat(token, containsString("."));
    }
}