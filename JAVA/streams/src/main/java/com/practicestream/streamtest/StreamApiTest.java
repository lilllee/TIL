package com.practicestream.streamtest;

import com.practicestream.beans.Color;
import com.practicestream.beans.People;
import com.practicestream.mockdata.MockData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiTest {

    private People peoples = new People();

    @Test
    @DisplayName("스트림 미사용")
    public void beforeStream() throws Exception {
        List<People> people = MockData.getPeople();
        List<People> oldPeople = new ArrayList<>();
        for (People person : people) {
            if (person.getAge() >= 50) {
                oldPeople.add(person);
            }
        }
        oldPeople.forEach(System.out::println);
    }

    @Test
    @DisplayName("스트림 사용")
    public void usingStream() throws Exception {
        List<People> people = MockData.getPeople();
        List<People> oldPeople = people.stream()
                .filter(people1 -> people1.getAge() >= 50)
                .collect(Collectors.toList());
        oldPeople.forEach(System.out::println);
    }

    @Test
    @DisplayName("성별에 따른 나이의 평균 값")
    public void name() throws Exception {
        List<People> people = MockData.getPeople();
        double male = peoples.GenderAgeAverage(people, "MALE");
        double female = peoples.GenderAgeAverage(people, "FEMALE");
        System.out.println(male + " " + female);
    }


    @Test
    public void exercise1() throws Exception {
        List<Color> colors = MockData.getColor();
        Predicate<Color> red = color -> color.getColoritem().equalsIgnoreCase("red");
        Predicate<Color> price = color -> color.getColorprice() > 200;

        colors.stream()
                .filter(red)
                .filter(price)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void exercise2() throws Exception {
        List<Color> colors = MockData.getColor();
        Predicate<Color> black = color -> color.getColoritem().equalsIgnoreCase("red");

        colors.stream()
                .filter(black)
                .map(color -> color.getColorprice() * 0.9)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void exercise3() throws Exception {
        List<People> people = MockData.getPeople();

        people.stream()
                .map(People::getFirstName)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                )
                .forEach(System.out::println);
    }

    @Test
    public void exercise4() throws Exception{
        System.out.println(
                MockData.getPeople()
                        .stream()
                        .filter(people -> {
                            System.out.println("filter :" + people);
                            return people.getAge() > 10;
                        })
                        .map(people -> {
                            System.out.println("map : " + people);
                            System.out.println("=================");
                            return people.getAge();
                        })
                        .collect(Collectors.toList())
        );
    }
}


