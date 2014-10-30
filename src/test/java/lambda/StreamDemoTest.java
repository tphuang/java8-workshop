package lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamDemoTest {

    private StreamDemo streamDemo;

    @Before
    public void setUp() throws Exception {
        streamDemo = new StreamDemo();
        streamDemo.initData();
    }

    @Test
    public void should_select_middle_adult_people_between_18_and_50() throws Exception {
        List result = streamDemo.handleFilter();
        assertThat(result.size(), is(5));
    }

    @Test
    public void should_sort_middle_adult_people_by_name_and_then_by_age() throws Exception {
        List<Person> expectedResult = asList(
                new Person("howard", 29),
                new Person("huang", 18),
                new Person("josey", 23),
                new Person("josey", 45),
                new Person("williams", 33));

        List result = streamDemo.handleSort();
        assertThat(result, is(expectedResult));
    }

    @Test
    public void should_capitalize_first_letter_of_name() throws Exception {
        List<Person> expectedResult = asList(
                new Person("Howard", 29),
                new Person("Huang", 18),
                new Person("Josey", 23),
                new Person("Josey", 45),
                new Person("Williams", 33));

        List result = streamDemo.handleCapitalize();
        assertThat(result, is(expectedResult));
    }

    @Test
    public void should_select_middle_adult_person_with_max_age() throws Exception {
        Person expectedResult = new Person("Josey", 45);
        Person result = streamDemo.selectPersonWithMaxAge();

        assertThat(result, is(expectedResult));
    }

    @Test
    public void should_get_average_age_of_middle_adult_people() throws Exception {
        double expectedResult = 29.6;
        double result = streamDemo.CalculateAverageAgeOfMiddleAdult();
        assertThat(result, is(expectedResult));
    }

    @Test
    public void should_group_middle_adult_people_by_first_letter() throws Exception {
        Map<String, List<Person>> expectedGroupMap = new TreeMap<>();
        expectedGroupMap.put("H", Arrays.asList(new Person("Howard", 29), new Person("Huang", 18)));
        expectedGroupMap.put("J", Arrays.asList(new Person("Josey", 23), new Person("Josey", 45)));
        expectedGroupMap.put("W", Arrays.asList(new Person("Williams", 33)));

        Map<String, List<Person>> groupMap = streamDemo.groupByFirstLetter();

        assertThat(groupMap.get("H"), is(expectedGroupMap.get("H")));
        assertThat(groupMap.get("J"), is(expectedGroupMap.get("J")));
        assertThat(groupMap.get("W"), is(expectedGroupMap.get("W")));
        assertThat(groupMap.get("H").get(0), is(expectedGroupMap.get("H").get(0)));
        assertThat(groupMap.get("H").get(1), is(expectedGroupMap.get("H").get(1)));
        assertThat(groupMap.get("J").get(0), is(expectedGroupMap.get("J").get(0)));
        assertThat(groupMap.get("J").get(1), is(expectedGroupMap.get("J").get(1)));
        assertThat(groupMap.get("W").get(0), is(expectedGroupMap.get("W").get(0)));
    }
}
