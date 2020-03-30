package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void creation(){
        User user = User.builder()
                .email("tester@email.com")
                .name("tester")
                .level(100L)
                .build();
        assertThat(user.getName(), is("tester"));
        assertThat(user.isAdmin(), is(true));
        assertThat(user.isActive(), is(true));

        user.deactivate();
        assertThat(user.isActive(), is(false));
    }

    @Test
    public void accessToken(){
        User user = User.builder().password("ACCESSTOKEN").build();
        assertThat(user.getAccessToken(),is("ACCESSTOKE"));
    }

    @Test
    public void accessTokenWithoutPassword(){
        User user = new User();
        assertThat(user.getAccessToken(),is(""));
    }
}