package kr.co.fastcampus.eatgo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Restaurant {

    private final Long id;
    private final String name;
    private final String address;
    private List<MenuItem> menuItem = new ArrayList<MenuItem>();

    public Restaurant(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItem.add(menuItem);
    }

    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(List<MenuItem> menuItems) {
        this.menuItem = menuItems;
    }
}
