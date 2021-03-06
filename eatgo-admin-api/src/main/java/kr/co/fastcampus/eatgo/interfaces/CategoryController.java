package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Category;
import kr.co.fastcampus.eatgo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> list(){
        List<Category> categories = categoryService.getCategories();
        return categories;
    }

    @PostMapping("/categories")
    public ResponseEntity create(@RequestBody Category category) throws URISyntaxException {
        categoryService.addCategory(category.getName());
        return ResponseEntity.created(new URI("/categories/1")).body("{}");
    }
}
