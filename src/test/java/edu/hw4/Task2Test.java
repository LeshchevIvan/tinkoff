package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
public class Task2Test {
    @Test
    @DisplayName("Сортировка по весу и выборка к первых")
    void test1() {
        // given
        List<Animal> animals=Animals.getData();

        // when
        List<Animal> sortedList=Task2.sortByWeight(animals,3);

        // then
        List<Animal> ans=new ArrayList<>();
        ans.addLast(new Animal("bim", Animal.Type.DOG, Animal.Sex.M, 7, 120, 7000, true));
        ans.addLast(new Animal("popa", Animal.Type.BIRD, Animal.Sex.M, 11, 10, 100, false));
        ans.addLast(new Animal("dora", Animal.Type.FISH, Animal.Sex.F, 1, 4, 38, false));
        assertThat(sortedList).isEqualTo(ans);
    }
}
