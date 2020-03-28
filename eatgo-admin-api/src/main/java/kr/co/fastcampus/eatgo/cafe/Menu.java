package kr.co.fastcampus.eatgo.cafe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cafeId;
    private String name;

    public Menu(Long id, Long cafeId, String name) {
        this.id = id;
        this.cafeId = cafeId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
