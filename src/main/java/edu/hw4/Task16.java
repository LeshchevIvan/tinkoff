package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task16 {

    public static List<Animal> sortByTypeSexName(List<Animal> animalList) {
        return animalList.stream().sorted(new SortByType()).sorted(new SortBySex()).
            sorted(new SortByName()).toList();
    }

    public static class SortByType implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o1.type().ordinal(), o2.type().ordinal());
        }
    }

    public static class SortBySex implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o1.sex().ordinal(), o2.sex().ordinal());
        }
    }

    public static class SortByName implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return String.CASE_INSENSITIVE_ORDER.compare(o1.name(), o2.name());
        }
    }

}
