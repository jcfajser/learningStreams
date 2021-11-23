package com.fajardo;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        System.out.println("*********************************************************");
        System.out.println("LIST OF PERSONS");
        people.forEach(System.out::println);
        System.out.println("*********************************************************");
        System.out.println();

        // Imperative approach

        /*List<Person> femalesImp = new ArrayList<>();

        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)){
                femalesImp.add(person);
            }
        }

        femalesImp.forEach(System.out::println);*/

        // Declarative approach

        // Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        System.out.println("*********************************************************");
        System.out.println("STREAM FILTER");
        System.out.println("Filter Persons By Gender == FEMALE");
        females.forEach(System.out::println);
        System.out.println("*********************************************************");
        System.out.println();

        // Sort
        List<Person> sortList = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        System.out.println("*********************************************************");
        System.out.println("STREAM SORT");
        System.out.println("Sort persons by Age ascending");
        sortList.forEach(System.out::println);
        System.out.println("*********************************************************");
        System.out.println();

        // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);

        System.out.println("*********************************************************");
        System.out.println("STREAM All match");
        System.out.println("All records match Age>8");
        System.out.println(allMatch);
        System.out.println("*********************************************************");
        System.out.println();

        // Any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 5);

        System.out.println("*********************************************************");
        System.out.println("STREAM Any match");
        System.out.println("Any records match Age>5");
        System.out.println(anyMatch);
        System.out.println("*********************************************************");
        System.out.println();

        // None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println("*********************************************************");
        System.out.println("STREAM None match");
        System.out.println("All records match name=Antonio");
        System.out.println(noneMatch);
        System.out.println("*********************************************************");
        System.out.println();

        // Max
        Optional<Person> max = people.stream()
                .max(Comparator.comparing(Person::getAge));

        System.out.println("*********************************************************");
        System.out.println("STREAM Max");
        System.out.println("Person with Max Age");
        System.out.println(max);
        System.out.println("*********************************************************");
        System.out.println();

        // Min
        System.out.println("*********************************************************");
        System.out.println("STREAM Min");
        System.out.println("Person With Min Age");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        System.out.println("*********************************************************");
        System.out.println();

        // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        System.out.println("*********************************************************");
        System.out.println("STREAM GroupBy");
        System.out.println("Persons group by Gender");
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });
        System.out.println("*********************************************************");
        System.out.println();


        // get the name of the female oldest
        System.out.println("*********************************************************");
        System.out.println("Oldest Female");
        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);
        System.out.println("*********************************************************");
        System.out.println();


    }

    private static List<Person> getPeople(){
       return List.of(
               new Person("Jame Bond", 20, Gender.MALE),
               new Person("Alina Smith", 33, Gender.FEMALE),
               new Person("Helen White", 57, Gender.FEMALE),
               new Person("Alex Boz", 14, Gender.MALE),
               new Person("Jamie Goa", 99, Gender.MALE),
               new Person("Anna Cook", 7, Gender.FEMALE),
               new Person("Zelda Brown", 120, Gender.FEMALE)
       );
    }
}
