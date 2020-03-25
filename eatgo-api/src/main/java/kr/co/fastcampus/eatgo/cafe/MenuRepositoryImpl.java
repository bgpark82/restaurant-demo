package kr.co.fastcampus.eatgo.cafe;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuRepositoryImpl implements MenuRepository {

    List<Menu> menus;

    public MenuRepositoryImpl() {
        menus = new ArrayList<>();
        menus.add(new Menu(1004L,"Latte"));
    }

    @Override
    public List<Menu> findByCafeId(Long id) {

        return menus;
    }
}
