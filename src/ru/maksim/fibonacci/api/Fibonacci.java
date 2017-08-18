package ru.maksim.fibonacci.api;

import java.math.BigInteger;

public class Fibonacci {

    private Fibonacci() {
        throw new AssertionError();
    }

    public static int fibonacciRec(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public static BigInteger fibonacciLog(int n) {
        if (n == 0) {
            return BigInteger.valueOf(n);
        }
        // TODO: Negative numbers
        BigInteger[][] result = {
                {BigInteger.valueOf(1), BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(0)}
        };
        BigInteger[][] rest = {
                {BigInteger.valueOf(1), BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(0)}
        };
        BigInteger[][] fiboM = {
                {BigInteger.valueOf(1), BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(0)}
        };

        while (n > 1) {
            if (n % 2 == 1) {
                multiplyMatrices(rest, fiboM);
            }
            multiplyMatrices(result, result);
            n /= 2;
        }
        multiplyMatrices(result, rest); // TODO: we don't have to do that when n is a power of 2
        return result[1][0];
    }

    private static void multiplyMatrices(BigInteger[][] result, BigInteger[][] other) {
        BigInteger el00 = result[0][0].multiply(other[0][0]).add(result[0][1].multiply(other[1][0]));
        BigInteger el01 = result[0][0].multiply(other[0][1]).add(result[0][1].multiply(other[1][1]));
        BigInteger el10 = result[1][0].multiply(other[0][0]).add(result[1][1].multiply(other[1][0]));
        BigInteger el11 = result[1][0].multiply(other[0][1]).add(result[1][1].multiply(other[1][1]));

        result[0][0] = el00;
        result[0][1] = el01;
        result[1][0] = el10;
        result[1][1] = el11;
    }
}
