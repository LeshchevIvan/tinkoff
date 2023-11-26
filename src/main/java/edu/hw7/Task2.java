package edu.hw7;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Task2 {
    public static BigInteger fact(int n) {
        if (n > 0) {
            return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .parallel()
                .reduce(BigInteger::multiply)
                .get();
        } else if (n == 0) {
            return BigInteger.ONE;

        } else {
            return BigInteger.ZERO;
        }
    }
}