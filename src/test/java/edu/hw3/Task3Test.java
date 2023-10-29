package edu.hw3;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class Task3Test {
    @Test
    @DisplayName("Проверка корректности работы с различными типами данных")
    void test1() {
        // given
        Object[] input =new Object[]{"this", "and", "that", 123,1.234,"and"};

        // when
        Map<Object, Integer> dict = Task3.freqDict(input);

        // then
        Map<Object, Integer> ans=new HashMap<>();
        ans.put("that",1);
        ans.put("and",2);
        ans.put("this",1);
        ans.put(1.234,1);
        ans.put(123,1);
        assertThat(dict).isEqualTo(ans);
    }

    @Test
    @DisplayName("Проверка корректности работы с одинаковыми типами данных")
    void test2() {
        // given
        Object[] input =new Object[]{"this", "and", "that","and"};

        // when
        Map<Object, Integer> dict = Task3.freqDict(input);

        // then
        Map<Object, Integer> ans=new HashMap<>();
        ans.put("that",1);
        ans.put("and",2);
        ans.put("this",1);
        assertThat(dict).isEqualTo(ans);
    }




}
