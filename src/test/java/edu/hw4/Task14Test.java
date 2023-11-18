package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task14Test {
    @Test
    @DisplayName("Есть ли в списке собака ростом более к")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        Boolean isExist=Task14.containsDogHigherThenK(animals,20);

        // then
        boolean ans=true;

        assertThat(isExist).isEqualTo(ans);
    }
}

