package edu.hw4;

import java.util.List;

public class Task17 {

    public static Boolean bytes(List<Animal> animalList) {

        long nSpiderBytes = animalList.stream().filter(animal -> animal.type() == Animal.Type.SPIDER).
            filter(animal -> animal.bites()).count();

        long nDogBytes = animalList.stream().filter(animal -> animal.type() == Animal.Type.DOG).
            filter(animal -> animal.bites()).count();
        return nSpiderBytes > nDogBytes;

    }

}





