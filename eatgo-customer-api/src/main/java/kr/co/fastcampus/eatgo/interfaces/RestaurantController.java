package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(@RequestParam String region, @RequestParam Long categoryId) {
        List<Restaurant> restaurants = restaurantService.getRestaurants(region, categoryId);
        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return restaurant;
    }





}
