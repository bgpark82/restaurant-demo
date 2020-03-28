package kr.co.fastcampus.eatgo.cafe;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @Transient
    private List<Menu> menus = new ArrayList<>();

    public Cafe(Long id, String name,  String address) {
        this.id = id;
        this.name=name;
        this.address = address;
    }

    public Cafe(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public String getName() { return name; }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public List<Menu> getMenu() { return menus; }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
