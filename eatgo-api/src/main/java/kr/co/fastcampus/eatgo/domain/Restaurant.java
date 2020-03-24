package kr.co.fastcampus.eatgo.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Entity
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  String address;
    @Transient
    private List<MenuItem> menuItem = new ArrayList<MenuItem>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

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

    public void setId(Long id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
