package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CategoryTest {

    @Test
    public void category(){
        Category category = Category.builder().name("category").build();
        assertThat(category.getName(),is("category"));
    }
}