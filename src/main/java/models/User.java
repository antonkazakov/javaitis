package models;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class User {

    private int id;

    private String name;

    private int age;

    private String city;



    public User(int id, String city, String name, int age) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
