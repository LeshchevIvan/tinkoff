package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task8 {

    public static Optional<Animal> lowerThenK(List<Animal> animalList, int high) {
        return animalList.stream().filter(k -> k.height() < high).sorted(new SortByWeight()).findFirst();
    }

    public static class SortByWeight implements Comparator<Animal> {

        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o2.weight(), o1.weight());

        }
    }

}
