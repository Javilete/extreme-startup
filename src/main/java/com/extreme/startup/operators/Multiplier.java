package com.extreme.startup.operators;

import java.util.List;
import java.util.regex.Matcher;

public class Multiplier extends Operator{

    private static Multiplier INSTANCE = null;

    private Multiplier() {

    }

    public static Multiplier getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Multiplier();
        }
        return INSTANCE;
    }

    @Override
    public String execute(Matcher matcher) {
        List<Integer> numbers = extractValues(matcher);
        int result = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        return String.valueOf(result);

    }
}
