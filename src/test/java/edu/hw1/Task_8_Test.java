import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_8_Test {
    @Test
    @DisplayName("Проверка входных данных (доска должны быть 8х8)")
    void checkSquare() {
        //given
        int[][] chessboard = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        //when
        boolean result = task8.knightBoardCapture(chessboard);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверка правильной расстановки")
    void checkTrue() {
        //given
        int[][] chessboard = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        //when
        boolean result = task8.knightBoardCapture(chessboard);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Проверка неправильной расстановки")
    void checkFalse() {
        //given
        int[][] chessboard = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        //when
        boolean result = task8.knightBoardCapture(chessboard);

        //then
        assertThat(result).isEqualTo(false);
    }
}