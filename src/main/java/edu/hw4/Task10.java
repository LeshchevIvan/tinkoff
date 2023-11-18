package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class Task10 {

    public static List<Animal> ageNotEqualToPaws(List<Animal> animalList) {
        return animalList.stream().filter(k -> k.age() != k.paws()).collect(Collectors.toList());
    }

}
