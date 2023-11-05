package edu.hw4;

import java.util.List;

public class Task14 {

    public static Boolean containsDogHigherThenK(List<Animal> animalList, int k) {
        return animalList.stream().filter(animal -> animal.type() == Animal.Type.DOG).anyMatch(dog -> dog.height() > k);
    }

}
