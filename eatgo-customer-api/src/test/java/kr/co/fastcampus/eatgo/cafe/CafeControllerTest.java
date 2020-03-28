package kr.co.fastcampus.eatgo.cafe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(CafeController.class)
public class CafeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CafeService cafeService;

    @Test
    public void list() throws Exception {
        List<Cafe> cafes = new ArrayList<>();
        Cafe cafe = new Cafe(1004L, "Bien", "Seoul");
        cafes.add(cafe);
        given(cafeService.findAll()).willReturn(cafes);

        mvc.perform(get("/cafes"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Bien")));
    }

    @Test
    public void getCafe() throws Exception {
        Cafe cafe = new Cafe(1004L, "Bien", "Seoul");
        List<Menu> menus = new ArrayList<>();
        Menu menu = new Menu(1004L, 1004L, "Latte");
        menus.add(menu);
        cafe.setMenus(menus);
        given(cafeService.findById(1004L)).willReturn(cafe);
        
        mvc.perform(get("/cafe/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Bien")))
                .andExpect(content().string(containsString("Latte")));
    }


}