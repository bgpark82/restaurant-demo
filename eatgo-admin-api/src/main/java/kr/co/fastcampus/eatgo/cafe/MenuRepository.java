package kr.co.fastcampus.eatgo.cafe;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    
    List<Menu> findByCafeId(Long id);
}
