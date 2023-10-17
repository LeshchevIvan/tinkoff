import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Task_1_Test {
    @Test
    @DisplayName("Проверка корректности ввода времени")
    void checkCorrect() {
        // given
        String time = "qwerty:123";

        // when
        int timeToSeconds = task1.minutesToSeconds(time);

        // then
        assertThat(timeToSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка ограничения на секунды")
    void checkCorrectSeconds() {
        // given
        String time = "1:60";

        // when
        int timeToSeconds = task1.minutesToSeconds(time);

        // then
        assertThat(timeToSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка правильности работы функции")
    void checkCorrectWorking() {
        // given
        String time = "02:50";

        // when
        int timeToSeconds = task1.minutesToSeconds(time);

        // then
        assertThat(timeToSeconds).isEqualTo(170);
    }
}