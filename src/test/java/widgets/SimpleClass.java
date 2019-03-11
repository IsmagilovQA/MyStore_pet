package widgets;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
public class SimpleClass {

    String name;
    String country;
    int age;

    public SimpleClass(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }
}