package kr.co.fastcampus.eatgo.cafe;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CafeController {


    @Autowired
    private CafeService cafeService;


    @GetMapping("/cafes")
    public List<Cafe> list(){
        return cafeService.findAll();
    }

    @GetMapping("/cafe/{id}")
    public Cafe get(@PathVariable Long id) {
        return cafeService.findById(id);
    }




}
