package kr.co.fastcampus.eatgo.service;

import kr.co.fastcampus.eatgo.domain.Reservation;
import kr.co.fastcampus.eatgo.domain.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }



    public Reservation addReservation(Long restaurantId, Long userId, String name, String date, String time, Integer partySize) {

        Reservation reservation = reservationRepository.save(Reservation.builder()
                .restaurantId(restaurantId)
                .userId(userId)
                .name(name)
                .date(date)
                .time(time)
                .partySize(partySize)
                .build());

        return reservation;
    }

    public List<Reservation> getReservation(Long restaurantId) {
        return reservationRepository.findByRestaurantId(restaurantId);
    }
}
