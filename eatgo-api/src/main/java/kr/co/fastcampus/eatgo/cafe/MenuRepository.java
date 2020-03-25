package kr.co.fastcampus.eatgo.cafe;

import java.util.List;

public interface MenuRepository {
    
    List<Menu> findByCafeId(Long id);
}
