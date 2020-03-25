package kr.co.fastcampus.eatgo.cafe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CafeRepository extends JpaRepository<Cafe, Long> {

    List<Cafe> findAll();
    Optional<Cafe> findById(Long id);
    Cafe save(Cafe cafe);
}
