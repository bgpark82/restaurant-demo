package kr.co.fastcampus.eatgo.util;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

class JwtUtilTest {


    private static final String SECRET = "123456789123456789123456789123456789";
    private JwtUtil jwtUtil;

    @BeforeEach
    public void setUp(){
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    public void createToken(){
        String token = jwtUtil.createToken(1004L,"John", null);
        assertThat(token, containsString("."));
    }

    @Test
    public void getClaims(){
        String token ="eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb2huIn0.a9AP5sserK1ikrOA0cvl0B8ndwiw2IS-TuwCzgQUpZY";
        Claims claims = jwtUtil.getClaims(token);
        assertThat(claims.get("name"),is("John"));
        assertThat(claims.get("userId",Long.class),is(1004L));
    }
}