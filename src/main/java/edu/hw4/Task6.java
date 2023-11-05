package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {

    public static Map<Animal.Type, Animal> heaviestAnimalMap(List<Animal> animalList) {

        Map<Animal.Type, Animal> HAMap = new HashMap<>();

        for (Animal animal : animalList) {
            if (HAMap.containsKey(animal.type())) {
                if (HAMap.get(animal.type()).weight() < animal.weight()) {
                    HAMap.put(animal.type(), animal);
                }
            } else {
                HAMap.put(animal.type(), animal);
            }
        }

        return HAMap;
    }

}
