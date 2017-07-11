package com.extreme.startup.operators;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PowOperatorShould {

    private PowOperator powOperator;

    @Before
    public void setUp() throws Exception {
        powOperator = PowOperator.getInstance();
    }

    @Test
    public void calculateThePowOfNumbersGiven() {
        String question = "what is 2 to the power of 11";
        String pattern = ".*what is (\\d+) to the power of (\\d+)";
        Matcher matcher = Pattern.compile(pattern).matcher(question);
        matcher.matches();

        String result = powOperator.execute(matcher);

        assertThat(result, is("2048"));
    }
}
