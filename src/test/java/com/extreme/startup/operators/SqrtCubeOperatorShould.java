package com.extreme.startup.operators;

import com.extreme.startup.operators.SqrtCubeOperator;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqrtCubeOperatorShould {

    private SqrtCubeOperator sqrtCubeOperator;

    @Before
    public void setUp() throws Exception {
        sqrtCubeOperator = SqrtCubeOperator.getInstance();
    }

    @Test
    public void calculateTheSqrtAndCubeOfaNumberSet() {
        String question = "which of the following numbers is both a square and a cube: 121, 249";
        String pattern = ".*which of the following numbers is both a square and a cube: (\\d+), (\\d+)";;
        Matcher matcher = Pattern.compile(pattern).matcher(question);
        matcher.matches();

        String result = sqrtCubeOperator.execute(matcher);

        assertThat(result, is("121"));
    }
}
