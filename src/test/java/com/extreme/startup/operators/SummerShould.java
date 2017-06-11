package com.extreme.startup.operators;

import com.extreme.startup.operators.Summer;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SummerShould {

    private Summer summer;

    @Before
    public void setUp() throws Exception {
        summer = Summer.getInstance();
    }

    @Test
    public void calculateSumOfValues() {
        String question = "what is 3 plus 16";
        String pattern = ".*what is (\\d+) plus (\\d+)";
        Matcher matcher = Pattern.compile(pattern).matcher(question);
        matcher.matches();

        String result = summer.execute(matcher);

        assertThat(result, is("19"));
    }
}
