import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_5_Test {
    @Test
    @DisplayName("Проверка палиндрома первого порядка")
    void checkInstantPalindrome() {
        //given
        Integer number = 101;

        //when
        boolean isPalindrome = task5.isPalindromeDescendant(number);

        //then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("Проверка палиндрома второго порядка")
    void checkFirstDescendantPalindrome() {
        //given
        Integer number = 123;

        //when
        boolean isPalindrome = task5.isPalindromeDescendant(number);

        //then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("Проверка палиндрома третьего порядка")
    void checkSecondDescendantPalindrome() {
        //given
        Integer number = 13001120;

        //when
        boolean isPalindrome = task5.isPalindromeDescendant(number);

        //then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("Проверка палиндрома четвертого порядка")
    void checkThirdDescendantPalindrome() {
        //given
        Integer number = 11211230;

        //when
        boolean isPalindrome = task5.isPalindromeDescendant(number);

        //then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("Проверка числа длиной один")
    void checkSingleDigitNumber() {
        //given
        Integer number = 1;

        //when
        boolean isPalindrome = task5.isPalindromeDescendant(number);

        //then
        assertThat(isPalindrome).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверка отрицательного числа")
    void checkNegativeNumber() {
        //given
        Integer number = -235;

        //when
        boolean isPalindrome = task5.isPalindromeDescendant(number);

        //then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("Проверка числа не палиндрома")
    void checkNotPalindromeNumber() {
        //given
        Integer number = 144;

        //when
        boolean isPalindrome = task5.isPalindromeDescendant(number);

        //then
        assertThat(isPalindrome).isEqualTo(false);
    }
}