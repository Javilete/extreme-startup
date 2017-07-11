package com.extreme.startup.operators;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FibonacciOperatorShould {

    private FibonacciOperator fibonacciOperator;

    @Before
    public void setUp() throws Exception {
        fibonacciOperator = FibonacciOperator.getInstance();
    }

    @Test
    public void returnTheNumberRequestedInTheFibonacciSequence() {
        String question = "what is the 10th number in the Fibonacci sequence";
        String pattern = ".*what is the (\\d+)th number in the Fibonacci sequence";
        Matcher matcher = Pattern.compile(pattern).matcher(question);
        matcher.matches();

        String result = fibonacciOperator.execute(matcher);

        assertThat(result, is("55"));
    }
}
