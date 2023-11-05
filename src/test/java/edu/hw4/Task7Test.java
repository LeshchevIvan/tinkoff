package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("k-e Самое старое животное")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        Animal animal = Task7.theOldestAnimalN(animals,3);

        // then
        Animal ans=new Animal("bim", Animal.Type.DOG, Animal.Sex.M, 7, 120, 7000, true);
        assertThat(animal).isEqualTo(ans);
    }
}

