package widgets;


import lombok.Data;

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