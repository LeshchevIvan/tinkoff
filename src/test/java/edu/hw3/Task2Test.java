package edu.hw3;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class Task2Test {
    @Test
    @DisplayName("Нет кластеров")
    void test1() {
        // given
        String brackets = "(((";

        // when
        ArrayList<String> clusters = Task2.clusterize(brackets);

        // then
        assertThat(clusters).isEqualTo(new ArrayList<String>(){});
    }

    @Test
    @DisplayName("Есть кластеры")
    void test2() {
        // given
        String brackets = "((()))()";

        // when
        ArrayList<String> clusters = Task2.clusterize(brackets);

        // then
        ArrayList<String> ans=new ArrayList<>();
        ans.add("((()))");
        ans.add("()");
        assertThat(clusters).isEqualTo(ans);
    }

    @Test
    @DisplayName("Некоректный ввод")
    void test3() {
        // given
        String brackets = "{((()))()}";

        // when
        ArrayList<String> clusters = Task2.clusterize(brackets);

        // then
        ArrayList<String> ans=new ArrayList<>();
        ans.add("Wrong input string!");
        assertThat(clusters).isEqualTo(ans);
    }


}
