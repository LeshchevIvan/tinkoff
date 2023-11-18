package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task15 {

    public static Map<Animal.Type, Integer> weightOfEachType(List<Animal> animalList, int k, int l) {
        List<Animal> keys = animalList.stream().filter(animal -> animal.age() > k).filter(animal -> animal.age() < l).
            toList();
        Map<Animal.Type, Integer> animalMap = new HashMap<>();
        for (Animal animal : keys) {
            animalMap.put(animal.type(), 0);
        }

        for (Animal animal : keys) {
            animalMap.put(animal.type(), animalMap.get(animal.type()) + animal.weight());
        }
        return animalMap;
    }

}
