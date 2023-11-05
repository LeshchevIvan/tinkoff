package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class Task17Test {
    @Test
    @DisplayName("Пауки кусаются чаще собак?")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        boolean moreBytes= Task17.bytes(animals);

        // then
        boolean ans =false;

        assertThat(moreBytes).isEqualTo(ans);
    }
}

