package edu.hw4;

import java.util.List;

public class Task9 {

    public static Integer sumPaws(List<Animal> animalList) {
        int paws = 0;
        for (Animal animal : animalList) {
            paws += animal.paws();
        }
        return paws;
    }

}
