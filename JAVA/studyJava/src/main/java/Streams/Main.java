package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        System.out.println("\n" + "==========GetFemalesList===========");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);

        //Filter
        System.out.println("\n" + "==========GetFemalesList===========");
        List<Person> femalesList = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        femalesList.forEach(System.out::println);

        //Sort
        System.out.println("\n" + "==========GetAgeSortList===========");
        List<Person> sortList = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        sortList.forEach(System.out::println);

        System.out.println("\n" + "==========GetAgeReverseSortList===========");
        List<Person> reverseSortList = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        reverseSortList.forEach(System.out::println);

        System.out.println("\n" + "==========GetGenderAgeSortList===========");
        List<Person> GenderSortList = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender))
                .collect(Collectors.toList());
        GenderSortList.forEach(System.out::println);

        //All match
        System.out.println("\n" + "==========allMatch===========");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 10);
        System.out.println(allMatch);

        //Any match
        System.out.println("\n" + "==========anyMatch===========");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 50);
        System.out.println(anyMatch);

        //None match
        System.out.println("\n" + "==========noneMatch===========");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Jung"));
        System.out.println(noneMatch);

        //Max
        System.out.println("\n" + "==========maxAge===========");
        Person maxAge = people.stream()
                .max(Comparator.comparing(Person::getAge))
                .get();
        System.out.println(maxAge);

        //Min
        System.out.println("\n" + "==========minAge===========");
        Person minAge = people.stream()
                .min(Comparator.comparing(Person::getAge))
                .get();
        System.out.println(minAge);

        //Group
        System.out.println("\n" + "==========groupByGender===========");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        }));

        System.out.println("\n" + "==========findOldestFemaleAge===========");
        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Lee", 26, Gender.MALE),
                new Person("Park", 28, Gender.MALE),
                new Person("Jin", 22, Gender.FEMALE),
                new Person("Su", 30, Gender.FEMALE),
                new Person("Jang", 26, Gender.MALE)
        );
    }
}
