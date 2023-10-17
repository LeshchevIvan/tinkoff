import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_4_Test {
    @Test
    @DisplayName("Проверка правильности работы функции со строкой четной длины")
    void checkEven() {
        //given
        String str = "badc14";

        //when
        String fixedString = task4.fixString(str);

        //then
        assertThat(fixedString).isEqualTo("abcd41");
    }

    @Test
    @DisplayName("Проверка правильности работы функции со строкой нечетной длины")
    void checkOdd() {
        //given
        String str = "badce";

        //when
        String fixedString = task4.fixString(str);

        //then
        assertThat(fixedString).isEqualTo("abcde");
    }

    @Test
    @DisplayName("Проверка правильности работы функции со строкой единичной длины")
    void checkSingleChar() {
        //given
        String str = "b";

        //when
        String fixedString = task4.fixString(str);

        //then
        assertThat(fixedString).isEqualTo("b");
    }

}