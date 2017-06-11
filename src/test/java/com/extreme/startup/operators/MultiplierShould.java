package com.extreme.startup.operators;

import com.extreme.startup.operators.Multiplier;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MultiplierShould {

    private Multiplier multiplier;

    @Before
    public void setUp() throws Exception {
        multiplier = Multiplier.getInstance();
    }

    @Test
    public void calculateTheMultiplyOfValues() {
        String question = "what is 5 multiplied by 8";
        String pattern = ".*what is (\\d+) multiplied by (\\d+)";
        Matcher matcher = Pattern.compile(pattern).matcher(question);
        matcher.matches();

        String result = multiplier.execute(matcher);

        assertThat(result, is("40"));
    }
}
