package kr.co.fastcampus.eatgo.cafe;

public class Menu {

    private Long id;
    private String name;

    public Menu(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
