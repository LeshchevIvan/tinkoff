import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_6_Test {
    @Test
    @DisplayName("Проверка ограничений на число n>1000")
    void checkLeftEdge() {
        //given
        int n = 805;

        //when
        int numIteration = task6.countK(n);

        //then
        assertThat(numIteration).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка ограничений на число n<10000")
    void checkRightEdge() {
        //given
        int n = 12345;

        //when
        int numIteration = task6.countK(n);

        //then
        assertThat(numIteration).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка неодинаковости всех цифр в числе")
    void checkOnlyOneDigitNum() {
        //given
        int n = 3333;

        //when
        int numIteration = task6.countK(n);

        //then
        assertThat(numIteration).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка правильности нахождения количества итераций")
    void checkNumberOfIteration() {
        //given
        int n = 1234;

        //when
        int numIteration = task6.countK(n);

        //then
        assertThat(numIteration).isEqualTo(3);
    }
}