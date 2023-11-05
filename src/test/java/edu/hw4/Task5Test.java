package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
public class Task5Test {
    @Test
    @DisplayName("Самцы или самки?")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        Animal.Sex sex = Task5.whichMore(animals);

        // then
        Animal.Sex ans = Animal.Sex.M;
        assertThat(sex).isEqualTo(ans);
    }
}
