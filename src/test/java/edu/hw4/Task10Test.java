package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task10Test {
    @Test
    @DisplayName("Список животных, возраст у которых не совпадает с количеством лап")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        List<Animal> animalList = Task10.ageNotEqualToPaws(animals);

        // then
        List<Animal> ans=new ArrayList<>();
        ans.addLast(new Animal("popa", Animal.Type.BIRD, Animal.Sex.M, 11, 10, 100, false));
        ans.addLast(new Animal("bestyCat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 9, true));
        ans.addLast(new Animal("dora", Animal.Type.FISH, Animal.Sex.F, 1, 4, 38, false));
        ans.addLast(new Animal("bim", Animal.Type.DOG, Animal.Sex.M, 7, 120, 7000, true));

        assertThat(animalList).isEqualTo(ans);
    }
}

