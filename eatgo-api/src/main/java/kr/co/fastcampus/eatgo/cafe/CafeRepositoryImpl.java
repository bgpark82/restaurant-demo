package kr.co.fastcampus.eatgo.cafe;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CafeRepositoryImpl implements CafeRepository{

    private List<Cafe> cafes;

    public CafeRepositoryImpl(){
        cafes = new ArrayList<>();
        cafes.add(new Cafe(1004L,"Bien","Seoul"));
        cafes.add(new Cafe(1004L,"Bien","Seoul"));
    }

    @Override
    public List<Cafe> findAll() {
        return cafes;
    }

    @Override
    public Cafe findById(Long id){
        return cafes.stream().filter(cafe -> cafe.getId().equals(id)).findFirst().get();
    }

    @Override
    public Cafe save(Cafe cafe) {
        return cafe;
    }
}
