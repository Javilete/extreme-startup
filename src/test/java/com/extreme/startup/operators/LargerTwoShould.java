package com.extreme.startup.operators;

import com.extreme.startup.operators.Larger;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LargerTwoShould {

    private Larger larger;

    @Before
    public void setUp() throws Exception {
        larger = Larger.getInstance();
    }

    @Test
    public void calculateTheLargestBetweenTheNumbersGiven() {
        String question = "which of the following numbers is the largest: 807, 67";
        String pattern = ".*which of the following numbers is the largest: (\\d+), (\\d+)";
        Matcher matcher = Pattern.compile(pattern).matcher(question);
        matcher.matches();

        String result = larger.execute(matcher);

        assertThat(result, is("807"));
    }
}
