package edu.hw3;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Task4Test {
    @Test
    @DisplayName("1984")
    void test1() {
        // given
        Integer arabicValue=1984;

        // when
        String romanValue = Task4.convertToRoman(arabicValue);

        // then
        assertThat(romanValue).isEqualTo("MCMLXXXIV");
    }

    @Test
    @DisplayName("999")
    void test2() {
        // given
        Integer arabicValue=999;

        // when
        String romanValue = Task4.convertToRoman(arabicValue);

        // then
        assertThat(romanValue).isEqualTo("CMXCIX");
    }

    @Test
    @DisplayName("Некоректный ввод")
    void test3() {
        // given
        Integer arabicValue=12345;

        // when
        String romanValue = Task4.convertToRoman(arabicValue);

        // then
        assertThat(romanValue).isEqualTo("Warning! \n" +
            "This function works with Integer values from 1 to 3999.");
    }

    @Test
    @DisplayName("Отрицательное число")
    void test4() {
        // given
        Integer arabicValue=-1;

        // when
        String romanValue = Task4.convertToRoman(arabicValue);

        // then
        assertThat(romanValue).isEqualTo("Warning! \n" +
            "This function works with Integer values from 1 to 3999.");
    }




}
