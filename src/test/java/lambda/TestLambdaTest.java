package lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestLambdaTest {
    private TestLambda testLambda;

    @Before
    public void setUp() throws Exception {
        testLambda = new TestLambda();
    }

    @Test
    public void testCompareWithOldMethod() throws Exception {
        List<String> expectedResult = Arrays.asList("Anna", "Mike", "Peter", "Williams");
        List<String> result = testLambda.compareWithOldMethod();

        assertThat(result, is(expectedResult));
    }

    @Test
    public void testCompareWithLambda() throws Exception {
        List<String> expectedResult = Arrays.asList("Anna", "Mike", "Peter", "Williams");
        List<String> result = testLambda.compareWithLambda();

        assertThat(result, is(expectedResult));
    }
}
