package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task9Test {
    @Test
    @DisplayName("Сколько в сумме лап у животных в списке")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        Integer paws = Task9.sumPaws(animals);

        // then
        Integer ans=22;

        assertThat(paws).isEqualTo(ans);
    }
}

