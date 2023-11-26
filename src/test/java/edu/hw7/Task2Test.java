package edu.hw7;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Task2Test {
    @Test
    @DisplayName("обработка нуля")
    void test1() {
        assertThat(Task2.fact(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("обработка отрицательных значений")
    void test2() {
        assertThat(Task2.fact(-123)).isEqualTo(0);
    }

    @Test
    @DisplayName("6!")
    void test3() {
        assertThat(Task2.fact(6)).isEqualTo(720);
    }




}
