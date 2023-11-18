package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    private static List<Animal> animals = new ArrayList<>();

    static {
        Animal bird = new Animal("popa", Animal.Type.BIRD, Animal.Sex.M, 11, 10, 100, false);
        Animal cat = new Animal("bestyCat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 9, true);
        Animal spider = new Animal("gena spider man", Animal.Type.SPIDER, Animal.Sex.M, 8, 1, 3, true);
        Animal dog = new Animal("force cap tail", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, false);
        Animal fish = new Animal("dora", Animal.Type.FISH, Animal.Sex.F, 1, 4, 38, false);
        Animal dog1 = new Animal("bim", Animal.Type.DOG, Animal.Sex.M, 7, 120, 7000, true);

        animals.add(bird);
        animals.add(cat);
        animals.add(spider);
        animals.add(dog);
        animals.add(fish);
        animals.add(dog1);
    }

    public static List<Animal> getData() {
        return animals;
    }
}
