import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_3_Test {
    @Test
    @DisplayName("Массив можно вложить")
    void checkTrue() {
        //given
        float[] arr1 = {1, 2, 3, 4};
        float[] arr2 = {0, 1, 2, 3, 4, 5};

        //when
        boolean isNestable = task3.isNestable(arr1, arr2);

        //then
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("Массив нельзя вложить")
    void checkFalse() {
        //given
        float[] arr1 = {2, 2, 23, 4};
        float[] arr2 = {0, 1, 2, 3, 4, 5};

        //when
        boolean isNestable = task3.isNestable(arr1, arr2);

        //then
        assertThat(isNestable).isEqualTo(false);
    }
}