package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    private Long categoryId;

    @NotEmpty
    private  String name;

    @NotEmpty
    private  String address;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuItem> menuItems;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<Review> reviews;


    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }

     public void setReivews(List<Review> reviews) {
        this.reviews = new ArrayList<>(reviews);
    }
}
