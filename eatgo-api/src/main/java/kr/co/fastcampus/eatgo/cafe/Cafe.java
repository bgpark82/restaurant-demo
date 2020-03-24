package kr.co.fastcampus.eatgo.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private Long id;
    private String name;
    private String address;
    private List<Menu> menu = new ArrayList<>();

    public Cafe(Long id, String name,  String address) {
        this.id = id;
        this.name=name;
        this.address = address;
    }


    public String getName() { return name; }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public List<Menu> getMenu() { return menu; }

    public void setMenu(Menu menu) {
        this.menu.add(menu);
    }
}
