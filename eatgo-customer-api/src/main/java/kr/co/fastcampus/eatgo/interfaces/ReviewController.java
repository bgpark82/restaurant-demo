package kr.co.fastcampus.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import kr.co.fastcampus.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list() {
        return reviewService.getReviews();

    }

    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ResponseEntity create(
            // Authentication 바로 사용가능
            Authentication authentication,
            @Valid @RequestBody Review resource,
            @PathVariable Long restaurantId) throws URISyntaxException {

        Claims claims = (Claims) authentication.getPrincipal();
        String name = claims.get("name",String.class);
        Integer score = resource.getScore();
        String description = resource.getDescription();
        Review review = reviewService.addReview(restaurantId, name, score, description);

        String url = "/restaurants/" + restaurantId + "/review/" + review.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
