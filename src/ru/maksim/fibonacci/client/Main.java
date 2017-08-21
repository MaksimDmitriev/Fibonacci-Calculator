package ru.maksim.fibonacci.client;

import ru.maksim.fibonacci.api.Fibonacci;

class Main {

    public static void main(String[] args) {
        for (int n = 1; n <= 16; n++) {
            System.out.print(Fibonacci.fibonacciRec(n) + " ");
        }

        System.out.println();
        for (int n = 1; n <= 16; n++) {
             System.out.print(Fibonacci.fibonacciLog(n) + " ");
        }

    }

}
