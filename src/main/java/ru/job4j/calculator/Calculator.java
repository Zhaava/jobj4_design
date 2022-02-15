package ru.job4j.calculator;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return x - y;
    }

    public  int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int sum = sum(5);
        int mult = new Calculator().multiply(5);
        int minus = Calculator.minus(5);
        int div = new Calculator().divide(3);

        System.out.println(sum);
        System.out.println(mult);
        System.out.println(minus);
        System.out.println(div);

        int result = new Calculator().sumAllOperation(10);

        System.out.println(result);
    }
}
