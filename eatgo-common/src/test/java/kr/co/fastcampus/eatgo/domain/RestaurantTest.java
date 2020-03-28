package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTest {

    @Test
    public void create(){
        Restaurant restaurant = Restaurant.builder()
                .name("Bien")
                .address("Seoul")
                .build();
        assertThat(restaurant.getName(),is("Bien"));
    }
}