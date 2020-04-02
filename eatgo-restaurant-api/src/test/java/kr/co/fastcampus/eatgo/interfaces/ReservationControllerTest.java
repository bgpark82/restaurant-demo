package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationController.class)
class ReservationControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    public void list() throws Exception {
        String token ="eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjIwMjAsIm5hbWUiOiJPd25lciIsInJlc3RhdXJhbnRJZCI6MTAwNH0.9ylWXMVzqqyUetR4ua9H_fLX2zow2v-dtttQUCwEv9Y";

        mvc.perform(get("/restaurants")
                .header("Authorization","Bearer " + token))
                .andExpect(status().isOk());
        verify(reservationService).getReservation(1004L);
    }
}