package edu.hw4;


import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static class SortByHigh implements Comparator<Animal> {

        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o1.height(), o2.height());

        }

    }

    public static List<Animal> sortByHigh(List<Animal> animals) {
        return animals.stream().sorted(new SortByHigh()).toList();
    }

}
