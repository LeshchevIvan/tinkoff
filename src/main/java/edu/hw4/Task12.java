package edu.hw4;

import java.util.List;

public class Task12 {

    public static long weightBiggerThenHeight(List<Animal> animalList) {
        return animalList.stream().filter(animal -> animal.weight() > animal.height()).count();
    }

}
