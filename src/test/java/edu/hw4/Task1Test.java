package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Сортировка по росту")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        List<Animal> sortedList = Task1.sortByHigh(animals);

        // then
        List<Animal> ans = new ArrayList<>();
        ans.addFirst(new Animal("bim", Animal.Type.DOG, Animal.Sex.M, 7, 120, 7000, true));
        ans.addFirst(new Animal("force cap tail", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, false));
        ans.addFirst(new Animal("bestyCat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 9, true));
        ans.addFirst(new Animal("popa", Animal.Type.BIRD, Animal.Sex.M, 11, 10, 100, false));
        ans.addFirst(new Animal("dora", Animal.Type.FISH, Animal.Sex.F, 1, 4, 38, false));
        ans.addFirst(new Animal("gena spider man", Animal.Type.SPIDER, Animal.Sex.M, 8, 1, 3, true));

        assertThat(sortedList).isEqualTo(ans);
    }

}
