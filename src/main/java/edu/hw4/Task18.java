package edu.hw4;

import java.util.List;

public class Task18 {

    public static Animal findTheHeaviestFish(List<Animal> list1, List<Animal> list2) {
        Animal f1 =
            list1.stream().filter(animal -> animal.type() == Animal.Type.FISH).sorted(new Task8.SortByWeight()).toList()
                .get(0);

        Animal f2 =
            list2.stream().filter(animal -> animal.type() == Animal.Type.FISH).sorted(new Task8.SortByWeight()).toList()
                .get(0);
        if (f1.weight() >= f2.weight()) {
            return f1;
        } else {
            return f2;
        }
    }

}
