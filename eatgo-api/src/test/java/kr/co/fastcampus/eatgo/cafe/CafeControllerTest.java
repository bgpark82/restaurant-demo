package kr.co.fastcampus.eatgo.cafe;

import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(CafeController.class)
public class CafeControllerTest {

    @Autowired
    private MockMvc mvc;

    @SpyBean(CafeRepositoryImpl.class)
    private CafeRepository cafeRepository;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/cafes"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Bien")));
    }

    @Test
    public void getCafe() throws Exception {
        mvc.perform(get("/cafe/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Bien")))
                .andExpect(content().string(containsString("Latte")));
    }

    @Test
    public void create() throws Exception {
        mvc.perform(post("/cafes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Beryong\",\"address\":\"Busan\"}"))
                .andExpect(status().isCreated());
    }
}