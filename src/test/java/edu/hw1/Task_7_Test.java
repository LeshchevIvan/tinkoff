import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_7_Test {
    @Test
    @DisplayName("Проверка правильности работы циклического сдвига вправо")
    void checkRotateRight() {
        //given
        int n = 123;
        int shift = 45;

        //when
        int result = task7.rotateRight(n, shift);

        //then
        assertThat(result).isEqualTo(63);
    }

    @Test
    @DisplayName("Проверка правильности работы циклического сдвига влево")
    void checkRotateLeft() {
        //given
        int n = 45;
        int shift = 4;

        //when
        int result = task7.rotateLeft(n, shift);

        //then
        assertThat(result).isEqualTo(27);
    }
}