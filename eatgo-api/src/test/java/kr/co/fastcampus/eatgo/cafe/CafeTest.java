package kr.co.fastcampus.eatgo.cafe;

import kr.co.fastcampus.eatgo.cafe.Cafe;
import kr.co.fastcampus.eatgo.cafe.Menu;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CafeTest {

    @Test
    public void create(){
        Cafe cafe = new Cafe(1004L,"Bien","Seoul");
        Menu menu = new Menu("Latte");
        cafe.setMenu(menu);
        assertThat(cafe.getName(),is("Bien"));
        assertThat(cafe.getId(),is(1004L));
        assertThat(cafe.getAddress(),is("Seoul"));
        assertThat(cafe.getMenu().get(0).getName(),is("Latte"));
    }
}