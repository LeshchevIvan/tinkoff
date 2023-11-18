package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task15Test {
    @Test
    @DisplayName("Найти суммарный вес животных каждого вида, которым от k до l лет")
    void test1() {
        // given
        List<Animal> animals = Animals.getData();

        // when
        Map<Animal.Type,Integer> typeMap=Task15.weightOfEachType(animals,1,8);

        // then
        Map<Animal.Type,Integer> ans=new HashMap<>();
        ans.put(Animal.Type.DOG,7008);
        ans.put(Animal.Type.CAT,9);

        assertThat(typeMap).isEqualTo(ans);
    }
}

