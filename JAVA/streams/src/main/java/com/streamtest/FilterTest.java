package com.streamtest;

import com.beans.People;
import com.mockdata.MockData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {

    @Test
    @DisplayName("Filter : 나이가 50 이상의 성별이 남자인 사람 50명 추출")
    public void name() throws Exception{
        List<People> people = MockData.getPeople();
        List<People> male = people.stream()
                .sorted(Comparator.comparing(People::getAge))
                .filter(people1 -> people1.getAge() >= 50)
                .filter(people1-> people1.getGender().toString().equals("MALE"))
                .limit(50)
                .collect(Collectors.toList());
        male.forEach(System.out::println);
    }
}
