import com.extreme.startup.service.MatcherService;
import com.extreme.startup.TextDictionary;
import com.extreme.startup.ExtremeStartup;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GuidingTest {

    private TextDictionary textDictionary;
    private MatcherService matcherService;
    private ExtremeStartup startup;

    @Before
    public void setUp() throws Exception {
        textDictionary = new TextDictionary();
        matcherService = new MatcherService(textDictionary);
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

    @Test
    public void shouldReturnPrimeNumbers() {
        String question = "which of the following numbers are primes: 901, 223";

        String response = startup.answer(question);

        assertThat(response, is("223"));
    }

    @Test
    public void shouldReturnPrimeNumbersOfFourLengthOfNumbers() {
        String question = "which of the following numbers are primes: 307, 420, 173, 347";

        String response = startup.answer(question);

        assertThat(response, is("307, 173, 347"));
    }

    @Test
    public void shouldReturnTextResultWhenQuestionIsWhoIsPrimeMinister() {
        String question = "who is the Prime Minister of Great Britain";

        String response = startup.answer(question);

        assertThat(response, is("Theresa May"));
    }

    @Test
    public void shouldReturnTheSubstractionResult() {
        String question = "what is 3 minus 8";

        String response = startup.answer(question);

        assertThat(response, is("-5"));
    }

    @Test
    public void shouldReturnTheNumberSpecifyInTheFibonacciSequence() {
        String question = "what is the 10th number in the Fibonacci sequence";

        String response = startup.answer(question);

        assertThat(response, is("55"));
    }

    @Test
    public void shouldReturnThePowerOfAnumber() {
        String question = "what is 2 to the power of 11";

        String response = startup.answer(question);

        assertThat(response, is("2048"));
    }

    @Test
    public void shouldReturnSumOfMoreThanTwoNumbers() {
        String question = "what is 12 plus 7 plus 2";

        String response = startup.answer(question);

        assertThat(response, is("21"));
    }
}
