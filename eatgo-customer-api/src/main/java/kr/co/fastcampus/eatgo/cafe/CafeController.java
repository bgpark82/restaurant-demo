package kr.co.fastcampus.eatgo.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
