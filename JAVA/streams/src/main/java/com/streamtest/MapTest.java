package com.streamtest;

import com.beans.People;
import com.beans.PeopleDTO;
import com.mockdata.MockData;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapTest {

    @Test
    @DisplayName("Map 사용해서 전달된 FEMALE 의 수가 같은지 확인 ")
    public void name() throws Exception {
        List<People> people = MockData.getPeople();

//        Function<People, PeopleDTO> peoplePeopleDTOFunction = people1 ->
//                new PeopleDTO(
//                        people1.getId(),
//                        people1.getFirstName(),
//                        people1.getAge()
//                );
        Function<People, PeopleDTO> peoplePeopleDTOFunction = PeopleDTO::map;

        List<PeopleDTO> peopleDTOList = people.stream()
                .filter(people1 -> people1.getGender()
                        .toString()
                        .equals("FEMALE"))
                .map(peoplePeopleDTOFunction)
                .collect(Collectors.toList());

        Assertions.assertEquals(peopleDTOList.size(), people.stream()
                .filter(people1 -> people1.getGender()
                        .toString()
                        .equals("FEMALE"))
                .count());

        peopleDTOList.forEach(System.out::println);
    }
}
