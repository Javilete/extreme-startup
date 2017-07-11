package com.extreme.startup.operators;

import java.util.regex.Matcher;

public class FibonacciOperator extends Operator{

    private static FibonacciOperator INSTANCE = null;

    private FibonacciOperator() {

    }

    public static FibonacciOperator getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new FibonacciOperator();
        }
        return INSTANCE;
    }

    @Override
    public String execute(Matcher matcher) {
        int number = Integer.parseInt(matcher.group(1));
        int value = calculateFibonacci(number);

        return String.valueOf(value);
    }

    private int calculateFibonacci(int number) {
        if (number == 0) {
            return 0;
        }

        if (number == 1 || number == 2) {
            return 1;
        }

        return calculateFibonacciHelper(0, 1, number);
    }

    private int calculateFibonacciHelper(int a, int b, int number) {
        if(number <= 0) {
            return a;
        }

        return calculateFibonacciHelper(b, a + b, number - 1);

    }
}
