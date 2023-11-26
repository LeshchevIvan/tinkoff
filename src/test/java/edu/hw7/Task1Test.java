package edu.hw7;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Task1Test {
    @Test
    @DisplayName("один поток")
    void test1() throws InterruptedException {
        assertThat(Task1.oneThread()).isEqualTo(1);
    }

    @Test
    @DisplayName("два потока")
    void test2() throws InterruptedException {
        assertThat(Task1.twoThreads()).isEqualTo(2);
    }

    @Test
    @DisplayName("три потока")
    void test3() throws InterruptedException {
        assertThat(Task1.threeThreads()).isEqualTo(3);
    }



}
