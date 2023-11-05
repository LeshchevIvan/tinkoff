package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task16Test {
    @Test
    @DisplayName("Список животных, отсортированный по виду, затем по полу, затем по имени")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        List<Animal> animalList = Task16.sortByTypeSexName(animals);

        // then
        List<Animal> ans = new ArrayList<>();
        ans.addLast(new Animal("bestyCat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 9, true));
        ans.addLast(new Animal("bim", Animal.Type.DOG, Animal.Sex.M, 7, 120, 7000, true));
        ans.addLast(new Animal("dora", Animal.Type.FISH, Animal.Sex.F, 1, 4, 38, false));
        ans.addLast(new Animal("force cap tail", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, false));
        ans.addLast(new Animal("gena spider man", Animal.Type.SPIDER, Animal.Sex.M, 8, 1, 3, true));
        ans.addLast(new Animal("popa", Animal.Type.BIRD, Animal.Sex.M, 11, 10, 100, false));

        assertThat(animalList).isEqualTo(ans);
    }
}

