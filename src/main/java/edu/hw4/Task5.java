package edu.hw4;

import java.util.List;

public class Task5 {

    public static Animal.Sex whichMore(List<Animal> animalList) {
        List<Animal.Sex> animalSex = animalList.stream().
            map(sex -> sex.sex()).toList();
        long nF = animalSex.stream().filter(sex -> sex == Animal.Sex.F).count();
        long nM = animalSex.stream().filter(sex -> sex == Animal.Sex.M).count();

        if (nF > nM) {
            return Animal.Sex.F;
        } else {
            return Animal.Sex.M;
        }
    }

}
