package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotNull
    private Long level;

    private String password;

    private Long restaurantId;

    public boolean isAdmin() {
        return level >= 100;
    }

    public boolean isActive() {
        return level > 0;
    }

    public void deactivate() {
        level = 0L;
    }

    public boolean isRestaurantOwner(){
        return this.level == 50L;
    };

    public void setRestaurantId(Long restaurantId) {
        this.level = 50L;
        this.restaurantId = restaurantId;
    }

    //    @JsonIgnore // password를 사용하지 않을 때 안보이도록 설정
//    public String getAccessToken() {
//        if(password == null){
//            return "";
//        }
//        return password.substring(0,10);
//    }
}
