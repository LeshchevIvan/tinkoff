package edu.hw3;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

public class Task7Test {
    @Test
    @DisplayName("Добавление null key")
    void test1() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7.nullComparator());
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }



}
