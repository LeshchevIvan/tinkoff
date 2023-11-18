package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Самое тяжелое животное среди животных ниже k см")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        Optional<Animal> animal = Task8.lowerThenK(animals,50);

        // then
        Optional<Animal> ans=Optional.of(new Animal("popa", Animal.Type.BIRD, Animal.Sex.M, 11, 10, 100, false));

        assertThat(animal).isEqualTo(ans);
    }
}

