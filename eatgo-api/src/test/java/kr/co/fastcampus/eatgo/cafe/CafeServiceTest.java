package kr.co.fastcampus.eatgo.cafe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class CafeServiceTest {

    CafeService cafeService;

    @Mock
    private CafeRepository cafeRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockCafeRepository();
        cafeService = new CafeService(cafeRepository);
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
    }

    @Test
    public void findAll(){
        List<Cafe> cafes = cafeService.findAll();
        assertThat(cafes.get(0).getName(), is("Bien"));
    }

}