package kr.co.fastcampus.eatgo.exception;

public class RestaurantNotFoundException extends RuntimeException {


    public RestaurantNotFoundException(Long id) {
        super("Could not find restaurant");
    }
}
