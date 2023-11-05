package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
public class Task3Test {
    @Test
    @DisplayName("Сортировка по весу и выборка к первых")
    void test1() {
        // given
        List<Animal> animals=Animals.getData();

        // when
        Map<Animal.Type,Integer> typeMap=Task3.countAnimalTypes(animals);

        // then
        Map<Animal.Type,Integer> ans=new HashMap<>();
        ans.put(Animal.Type.CAT,1);
        ans.put(Animal.Type.DOG,2);
        ans.put(Animal.Type.FISH,1);
        ans.put(Animal.Type.BIRD,1);
        ans.put(Animal.Type.SPIDER,1);


        assertThat(typeMap).isEqualTo(ans);
    }
}
