package kr.co.fastcampus.eatgo.interfaces;


import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.Review;
import kr.co.fastcampus.eatgo.exception.RestaurantNotFoundException;
import kr.co.fastcampus.eatgo.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(RestaurantController.class)
public class  RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .categoryId(1L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        restaurants.add(restaurant);
        given(restaurantService.getRestaurants("Seoul",1L)).willReturn(restaurants);

        mvc.perform(get("/restaurants?region=Seoul&categoryId=1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
    }

    @Test
    public void detailWithExist() throws Exception {
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        restaurant.setMenuItems(Arrays.asList(MenuItem.builder().name("Kimchi").build()));
        Review review = Review.builder()
                .name("JOKER")
                .score(5)
                .description("Great!")
                .build();
        restaurant.setReivews(Arrays.asList(review));
        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant);

        mvc.perform(get("/restaurant/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("Kimchi")))
                .andExpect(content().string(containsString("Great!")));



    }

    @Test
    public void detailWithNotExist() throws Exception {
        given(restaurantService.getRestaurant(404L))
                .willThrow(new RestaurantNotFoundException(404L));

        mvc.perform(get("/restaurant/404"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("{}"));
    }
}