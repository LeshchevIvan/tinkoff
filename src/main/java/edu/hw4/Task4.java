package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4 {
    public static Animal mostLongName(List<Animal> animalList) {
        List<Animal> copyOfAnimalList = new ArrayList<>(animalList);
        int index;
        index = animalList.size() - 1;
        while (index != 0) {
            if (copyOfAnimalList.get(index).name().length() > copyOfAnimalList.get(index - 1).name().length()) {
                Collections.swap(copyOfAnimalList, index, index - 1);
                index--;
            } else {
                index--;
            }
        }

        return copyOfAnimalList.get(0);
    }

}
