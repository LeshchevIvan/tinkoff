package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class Task12Test {
    @Test
    @DisplayName("Сколько в списке животных, вес которых превышает рост")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        long nAnimals = Task12.weightBiggerThenHeight(animals);

        // then
        int ans = 4;
        assertThat(nAnimals).isEqualTo(ans);
    }
}

