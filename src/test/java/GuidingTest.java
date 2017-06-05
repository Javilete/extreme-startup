import com.extreme.startup.Calculator;
import com.extreme.startup.ExtremeStartup;
import com.extreme.startup.MatcherService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GuidingTest {

    private Calculator calculator;
    private MatcherService matcherService;
    private ExtremeStartup startup;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
        matcherService = new MatcherService(calculator);
        startup = new ExtremeStartup("TeamSpirit", matcherService);
    }

    @Test
    public void shouldReturnTheTotalOfSumQuestions() {
        String question = "what is 3 plus 16";

        String response = startup.answer(question);

        assertThat(response, is("19"));
    }

    @Test
    public void shouldReturnTheLargestBetweenNumbers() {
        String question = "which of the following numbers is the largest: 807, 67";

        String response = startup.answer(question);

        assertThat(response, is("807"));
    }

    @Test
    public void shouldReturnTheLargestBetweenFourLengthOfNumbers() {
        String question = "which of the following numbers is the largest: 417, 67, 15, 120";

        String response = startup.answer(question);

        assertThat(response, is("417"));
    }

    @Test
    public void shouldReturnTheMultiplyOfNumbers() {
        String question = "what is 5 multiplied by 8";

        String response = startup.answer(question);

        assertThat(response, is("40"));
    }

    @Test
    public void shouldReturnCubAndSquareOfNumber() {
        String question = "which of the following numbers is both a square and a cube: 121, 249";

        String response = startup.answer(question);

        assertThat(response, is("121"));
    }

    @Test
    public void shouldReturnCubAndSquareOfNumberOfFourLengthOfNumbers() {
        String question = "which of the following numbers is both a square and a cube: 236, 64, 592, 784";

        String response = startup.answer(question);

        assertThat(response, is("64"));
    }
}
