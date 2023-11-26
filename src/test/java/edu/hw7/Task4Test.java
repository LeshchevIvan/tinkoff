package edu.hw7;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Task4Test {
    @Test
    @DisplayName("Однопоток")
    void test1() {
        assertThat(Task4.singleThread(1000000)).isCloseTo(3.141592, Percentage.withPercentage(0.1));
    }

    @Test
    @DisplayName("Многопоток")
    void test2() throws InterruptedException {
        var piCalculator = new Task4();
        assertThat(piCalculator.multiThread(1000000,6)).isCloseTo(3.141592, Percentage.withPercentage(0.1));
    }

}
