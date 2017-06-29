package com.extreme.startup.operators;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubstracterShould {

    private Substracter substracter;

    @Before
    public void setUp() throws Exception {
        substracter = Substracter.getInstance();
    }

    @Test
    public void calculateTheSubstractionOfNumbers() {
        String question = "what is 3 minus 8";
        String pattern = ".*what is (\\d+) minus (\\d+)";
        Matcher matcher = Pattern.compile(pattern).matcher(question);
        matcher.matches();

        String result = substracter.execute(matcher);

        assertThat(result, is("-5"));
    }
}
