package models;

import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class User {

    /**
     * User id
     */
    private int id;

    /**
     * User name
     */
    private String name;

    /**
     * User age
     */
    private int age;

    /**
     * User city
     */
    private String city;

    /**
     * User car list
     */
    private List<Auto> autos;

    public User(int id, String city, String name, int age) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.age = age;
    }

    public User(int id, List<Auto> autos, String city, String name, int age) {
        this.id = id;
        this.autos = autos;
        this.city = city;
        this.name = name;
        this.age = age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
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

    public static class Builder {
        /**
         * User id
         */
        private int id;

        /**
         * User name
         */
        private String name;

        /**
         * User age
         */
        private int age;

        /**
         * User city
         */
        private String city;

        /**
         * User car list
         */
        private List<Auto> autos;


        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setCity(String city){
            this.city = city;
            return this;
        }

        public Builder setAutos(List<Auto> autos){
            this.autos = autos;
            return this;
        }

        public User build(){
            return new User(id,autos,city,name,age);
        }
    }
}
