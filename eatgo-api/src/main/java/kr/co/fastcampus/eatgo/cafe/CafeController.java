package kr.co.fastcampus.eatgo.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CafeController {

    @Autowired
    private CafeRepository cafeRepository;

    @GetMapping("/cafes")
    public List<Cafe> list(){
        List<Cafe> cafes = cafeRepository.findAll();
        Menu menu = new Menu("Latte");
        return cafes;
    }

    @GetMapping("/cafe/{id}")
    public Cafe get(@PathVariable Long id) {
        Cafe cafe = cafeRepository.findById(id);
        cafe.setMenu(new Menu("Latte"));
        return cafe;
    }
}
