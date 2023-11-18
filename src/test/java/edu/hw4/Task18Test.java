package edu.hw4;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class Task18Test {
    @Test
    @DisplayName("Самая тяжелая рыбка")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();
        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("goldfish", Animal.Type.FISH, Animal.Sex.M,10,23,1,false));
        animals1.add(new Animal("blackfish", Animal.Type.FISH, Animal.Sex.M,17,26,34,false));
        animals1.add(new Animal("yellowfish", Animal.Type.FISH, Animal.Sex.M,12,3,6,false));

        // when
        Animal fish= Task18.findTheHeaviestFish(animals, animals1);

        // then
        Animal ans = new Animal("dora", Animal.Type.FISH, Animal.Sex.F, 1, 4, 38, false);

        assertThat(fish).isEqualTo(ans);
    }
}

