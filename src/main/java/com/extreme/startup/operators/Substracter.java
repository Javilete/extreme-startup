package com.extreme.startup.operators;

import java.util.List;
import java.util.regex.Matcher;

public class Substracter extends Operator{

    private static Substracter INSTANCE = null;

    private Substracter() {

    }

    public static Substracter getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Substracter();
        }
        return INSTANCE;
    }

    @Override
    public String execute(Matcher matcher) {
        int result = Integer.parseInt(matcher.group(1)) - Integer.parseInt(matcher.group(2));

        return String.valueOf(result);
    }
}
