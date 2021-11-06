package com.beans;

import java.util.Objects;

public class PeopleDTO {

    private final Integer id;
    private final String name;
    private final Integer age;

    public PeopleDTO(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PeopleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static PeopleDTO map(People people){
        return new PeopleDTO(
                people.getId(),
                people.getFirstName(),
                people.getAge());
    }
}
