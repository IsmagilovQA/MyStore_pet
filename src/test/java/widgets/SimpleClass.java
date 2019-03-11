package widgets;


import java.util.Objects;


public class SimpleClass {

    String name;
    String country;
    int age;

    public SimpleClass(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleClass that = (SimpleClass) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, age);
    }
}
