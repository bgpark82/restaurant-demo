package kr.co.fastcampus.eatgo.cafe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class CafeServiceTest {

    private CafeService cafeService;

    @Mock
    private CafeRepository cafeRepository;
    @Mock
    private MenuRepository menuRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockCafeRepository();
        mockMenuRepository();
        cafeService = new CafeService(cafeRepository, menuRepository);
    }

    private void mockMenuRepository() {
        List<Menu> menus = new ArrayList<>();
        Menu menu = new Menu(1004L, 1004L, "Latte");
        menus.add(menu);
        given(menuRepository.findByCafeId(1004L)).willReturn(menus);
    }

    private void mockCafeRepository() {
        List<Cafe> cafes = new ArrayList<>();
        Cafe cafe = new Cafe(1004L, "Bien", "Seoul");
        cafes.add(cafe);
        given(cafeRepository.findAll()).willReturn(cafes);
        given(cafeRepository.findById(1004L)).willReturn(Optional.of(cafe));
    }

    @Test
    public void findById() {
        Cafe cafe = cafeService.findById(1004L);
        assertThat(cafe.getName(), is("Bien"));
        assertThat(cafe.getMenu().get(0).getName(), is("Latte"));
    }

    @Test
    public void findAll(){
        List<Cafe> cafes = cafeService.findAll();
        assertThat(cafes.get(0).getName(), is("Bien"));
    }

}