package edu.hw3;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    @DisplayName("Только латиница")
    void test1() {
        // given
        String message = "ZYX";

        // when
        String encode = Task1.encode(message);

        // then
        assertThat(encode).isEqualTo("ABC");
    }

    @Test
    @DisplayName("Латиница + другие символы")
    void test2() {
        // given
        String message = "ZаY1X.";

        // when
        String encode = Task1.encode(message);

        // then
        assertThat(encode).isEqualTo("AаB1C.");
    }


}
