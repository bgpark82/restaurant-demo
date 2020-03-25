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
    private CafeRepository cafeRepository;
    @Autowired
    private MenuRepository menuRepository;


    @GetMapping("/cafes")
    public List<Cafe> list(){
        List<Cafe> cafes = cafeRepository.findAll();
        return cafes;
    }

    @GetMapping("/cafe/{id}")
    public Cafe get(@PathVariable Long id) {
        Cafe cafe = cafeRepository.findById(id);
        List<Menu> menus =menuRepository.findByCafeId(id);
        cafe.setMenus(menus);

        return cafe;
    }




}
