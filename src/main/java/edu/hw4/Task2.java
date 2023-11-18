package edu.hw4;


import java.util.List;
import java.util.Collections;

public class Task2 {
    public static List<Animal> sortByWeight(List<Animal> animalList, int k){
        // Второй вариант решения данной задачи воспользоваться встроенным методом sort с использованием
        // собственного компаратора, но в таком случаебудет отсотрирован весь список, поэтому я решил сделать
        // так, по моему мнению этот способ должен быть быстрее
        int index;
        for (int i = 0; i < k; i++) {
            index=animalList.size()-1;
            while (index!=0){
                if(animalList.get(index).weight()>animalList.get(index-1).weight()){
                    Collections.swap(animalList, index, index-1);
                    index--;
                }
                else {
                    index--;
                }
            }
        }
        return animalList.subList(0,k);
    }
}
