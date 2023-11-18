package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Животное с самым длинным именем")
    void test1() {
        // given
        List<Animal> animals=Animals.getData();

        // when
        Animal animal=Task4.mostLongName(animals);

        // then
        Animal ans=new Animal("gena spider man", Animal.Type.SPIDER, Animal.Sex.M, 8, 1, 3, true);


        assertThat(animal).isEqualTo(ans);
    }
}
