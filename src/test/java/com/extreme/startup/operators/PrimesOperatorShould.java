package com.extreme.startup.operators;

import com.extreme.startup.operators.PrimesOperator;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimesOperatorShould {

    private PrimesOperator primesOperator;

    @Before
    public void setUp() throws Exception {
        primesOperator = PrimesOperator.getInstance();
    }

    @Test
    public void returnThePrimeNumbersOfAsetGiven() {
        String question = "which of the following numbers are primes: 901, 223";
        String pattern = ".*which of the following numbers are primes: (\\d+), (\\d+)";
        Matcher matcher = Pattern.compile(pattern).matcher(question);
        matcher.matches();

        String result = primesOperator.execute(matcher);

        assertThat(result, is("223"));
    }
}
