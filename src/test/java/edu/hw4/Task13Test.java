package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task13Test {
    @Test
    @DisplayName("Список животных, имена которых состоят из более чем двух слов")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        List<Animal> animalList=Task13.longName(animals);

        // then
        List<Animal> ans = new ArrayList<>();
        ans.addFirst(new Animal("force cap tail", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, false));
        ans.addFirst(new Animal("gena spider man", Animal.Type.SPIDER, Animal.Sex.M, 8, 1, 3, true));

        assertThat(animalList).isEqualTo(ans);
    }
}

