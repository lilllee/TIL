package com.beans;

import java.util.List;

public class People {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String gender;


    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    public double GenderAgeAverage(List<People> peopleList, String gender) {
        return peopleList.stream()
                .filter(people -> people.getGender().equals(gender))
                .mapToInt(People::getAge)
                .average()
                .getAsDouble();
    }
}
