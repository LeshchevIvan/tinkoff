package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task11Test {
    @Test
    @DisplayName("Список животных, который могут укусить и рост которых больше 100 см")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        List<Animal> animalList = Task11.isBytesAndHigherThenK(animals);

        // then
        List<Animal> ans=new ArrayList<>();
        ans.addLast(new Animal("bim", Animal.Type.DOG, Animal.Sex.M, 7, 120, 7000, true));

        assertThat(animalList).isEqualTo(ans);
    }
}

