package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task7 {

    public static Animal theOldestAnimalN(List<Animal> animalList, int k) {
        List<Animal> copyOfAnimalList = new ArrayList<>(animalList);
        int index;
        for (int i = 0; i < k; i++) {
            index = animalList.size() - 1;
            while (index != 0) {
                if (copyOfAnimalList.get(index).age() > copyOfAnimalList.get(index - 1).age()) {
                    Collections.swap(copyOfAnimalList, index, index - 1);
                    index--;
                } else {
                    index--;
                }
            }
        }
        return copyOfAnimalList.get(k - 1);
    }

}
