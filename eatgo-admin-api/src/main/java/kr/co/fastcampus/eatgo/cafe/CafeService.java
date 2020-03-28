package kr.co.fastcampus.eatgo.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeService {

    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private MenuRepository menuRepository;

    public CafeService(CafeRepository cafeRepository, MenuRepository menuRepository) {
        this.cafeRepository = cafeRepository;
        this.menuRepository = menuRepository;
    }


    public Cafe findById(Long id) {
        Cafe cafe = cafeRepository.findById(id).orElse(null);
        List<Menu> menus = menuRepository.findByCafeId(id);
        cafe.setMenus(menus);
        return cafe;
    }

    public List<Cafe> findAll() {
        return cafeRepository.findAll();
    }
}
