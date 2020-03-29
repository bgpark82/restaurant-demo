package kr.co.fastcampus.eatgo.service;

import kr.co.fastcampus.eatgo.domain.Category;
import kr.co.fastcampus.eatgo.domain.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class CategoryServiceTest {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockCategoryRepository();
        categoryService = new CategoryService(categoryRepository);
    }

    private void mockCategoryRepository() {
        List<Category> mockCategory = new ArrayList<>();
        mockCategory.add(Category.builder().name("category").build());
        given(categoryRepository.findAll()).willReturn(mockCategory);
    }

    @Test
    public void getCategories(){

        List<Category> categories =  categoryService.getCategories();
        Category category = categories.get(0);
        assertThat(category.getName(), is("category"));

        verify(categoryRepository).findAll();
    }

    @Test
    public void addCategory(){


        Category category = categoryService.addCategory("category");
        assertThat(category.getName(),is("category"));

        verify(categoryRepository).save(any());
    }
}