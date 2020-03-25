package kr.co.fastcampus.eatgo.cafe;

import java.util.List;


public interface CafeRepository {

     List<Cafe> findAll();
     Cafe findById(Long id);
    Cafe save(Cafe cafe);
}
