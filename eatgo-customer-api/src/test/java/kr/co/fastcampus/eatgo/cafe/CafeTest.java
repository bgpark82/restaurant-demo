package kr.co.fastcampus.eatgo.cafe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CafeTest {

    @Test
    public void create(){
        Cafe cafe = new Cafe(1004L,"Bien","Seoul");
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1004L, 1004L, "Latte"));
        cafe.setMenus(menus);
        assertThat(cafe.getName(),is("Bien"));
        assertThat(cafe.getId(),is(1004L));
        assertThat(cafe.getAddress(),is("Seoul"));
        assertThat(cafe.getMenu().get(0).getName(),is("Latte"));
    }
}