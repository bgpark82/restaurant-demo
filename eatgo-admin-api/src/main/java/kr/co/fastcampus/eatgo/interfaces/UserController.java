package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list(){
        return userService.getUsers();
    }

    @PostMapping("/users")
    public ResponseEntity create(@RequestBody User resource) throws URISyntaxException {
        String email = resource.getEmail();
        String name = resource.getName();
        User user = userService.addUser(email,name);
        String url = "/users/" + user.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

    @PatchMapping("/user/{id}")
    public String update(@PathVariable Long id, @RequestBody User resource){
        String email = resource.getEmail();
        String name = resource.getName();
        Long level = resource.getLevel();
        userService.updateUser(id, email, name, level);
        return "{}";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id){
        userService.deleteUser(id);
        return "{}";
    }
    // 1. User list
    // 2. User create
    // 3. User update
    // 4. User delete -> level : 0
    // (1: customer, 2: restaurant owner, 3: admin)
}
