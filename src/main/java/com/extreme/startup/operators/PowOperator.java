package com.extreme.startup.operators;

import java.util.regex.Matcher;

public class PowOperator extends Operator {

    private static PowOperator INSTANCE;

    private PowOperator() {
    }

    public static PowOperator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PowOperator();
        }
        return INSTANCE;
    }

    @Override
    public String execute(Matcher matcher) {
        double base = Double.valueOf(matcher.group(1));
        double exponent = Double.valueOf(matcher.group(2));

        double result = Math.pow(base, exponent);
        return String.valueOf(Math.round(result));
    }
}
