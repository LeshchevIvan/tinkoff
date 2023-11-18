package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Самое тяжелое животное каждого вида")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        Map<Animal.Type, Animal> heaviestTypeMap = Task6.heaviestAnimalMap(animals);

        // then
        Map<Animal.Type, Animal> ans = new HashMap<>();
        ans.put(Animal.Type.CAT, new Animal("bestyCat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 9, true));
        ans.put(Animal.Type.DOG, new Animal("bim", Animal.Type.DOG, Animal.Sex.M, 7, 120, 7000, true));
        ans.put(Animal.Type.FISH, new Animal("dora", Animal.Type.FISH, Animal.Sex.F, 1, 4, 38, false));
        ans.put(Animal.Type.SPIDER, new Animal("gena spider man", Animal.Type.SPIDER, Animal.Sex.M, 8, 1, 3, true));
        ans.put(Animal.Type.BIRD, new Animal("popa", Animal.Type.BIRD, Animal.Sex.M, 11, 10, 100, false));
        assertThat(heaviestTypeMap).isEqualTo(ans);
    }
}
