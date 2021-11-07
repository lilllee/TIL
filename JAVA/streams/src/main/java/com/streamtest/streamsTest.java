package com.streamtest;

import com.beans.People;
import com.mockdata.MockData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class streamsTest {

    private People peoples = new People();

    @Test
    @DisplayName("스트림 미사용")
    public void beforeStream() throws Exception{
        List<People> people = MockData.getPeople();
        List<People> oldPeople = new ArrayList<>();
        for (People person : people) {
            if (person.getAge() >= 50){
                oldPeople.add(person);
            }
        }
        oldPeople.forEach(System.out::println);
    }

    @Test
    @DisplayName("스트림 사용")
    public void usingStream() throws Exception{
        List<People> people = MockData.getPeople();
        List<People> oldPeople = people.stream()
                .filter(people1 -> people1.getAge() >= 50)
                .collect(Collectors.toList());
        oldPeople.forEach(System.out::println);
    }

    @Test
    @DisplayName("성별에 따른 나이의 평균 값")
    public void name() throws Exception{
        List<People> people = MockData.getPeople();
        double male = peoples.GenderAgeAverage(people, "MALE");
        double female = peoples.GenderAgeAverage(people, "FEMALE");
        System.out.println(male);
        System.out.println(female);
    }
}


