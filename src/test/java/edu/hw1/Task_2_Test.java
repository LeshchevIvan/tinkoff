import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_2_Test{
    @Test
    @DisplayName("Проверка корректности работы с положительными числами")
    void testPositive(){
        // given
        int num=12345;

        // when
        int nDigit=task2.countDigits(num);

        // then
        assertThat(nDigit).isEqualTo(5);
    }
    @Test
    @DisplayName("Проверка корректности работы с отрицательными числами")
    void testNegative(){
        // given
        int num=-5212;

        // when
        int nDigit=task2.countDigits(num);

        // then
        assertThat(nDigit).isEqualTo(4);
    }
}