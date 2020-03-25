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

    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }


    public Cafe findById(Long id) {
        Cafe cafe = cafeRepository.findById(id).orElse(null);
        return cafe;
    }

    public List<Cafe> findAll() {
        return cafeRepository.findAll();
    }
}
