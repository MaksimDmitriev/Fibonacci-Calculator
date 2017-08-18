package ru.maksim.fibonacci.client;

import ru.maksim.fibonacci.api.Fibonacci;

class Main {

    public static void main(String[] args) {
        System.out.println(Fibonacci.fibonacciLog(8));
         System.out.println(Fibonacci.fibonacciRec(8));
    }

}
