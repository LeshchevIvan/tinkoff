package edu.hw4;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    public static Map<Animal.Type, Integer> countAnimalTypes(List<Animal> animalList) {
        Map<Animal.Type, Integer> animalTypes = new HashMap<>();

        for (Animal animal : animalList) {
            if (animalTypes.containsKey(animal.type())) {
                animalTypes.put(animal.type(), animalTypes.get(animal.type()) + 1);
            } else {
                animalTypes.put(animal.type(), 1);
            }
        }
        return animalTypes;
    }

}
