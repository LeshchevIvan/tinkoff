package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class Task11 {

    public static List<Animal> isBytesAndHigherThenK(List<Animal>animalList){
        return animalList.stream().filter(animal-> animal.bites()).filter(animal ->animal.height()>100).
            collect(Collectors.toList());

    }
}
