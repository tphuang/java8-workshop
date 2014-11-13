package lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StreamDemo {

    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public List<Person> initData() {
        return asList(
                new Person("jim", 11),
                new Person("josey", 45),
                new Person("huang", 18),
                new Person("josey", 23),
                new Person("peng", 62),
                new Person("williams", 33),
                new Person("howard", 29));
    }

    /* filter()
    @param Predicate (#test)
    @return Stream */
    public List<Person> handleFilter() {
        return initData().stream() //包装成stream
                .collect(Collectors.toList()); //Stream转化为List
    }

    /* sorted()
    @param Comparator (#compare)
    @return Stream */
    public List<Person> handleSort() {
        return null;
    }

    /* map()
    @param Function<Person, Object> (#apply)
    @return Stream */
    public List<Person> handleCapitalize() {
        return null;
    }

    /* reduce()
    @param BinaryOperator<Person> （#apply）
    @return Optional */
    public Person selectPersonWithMaxAge() {
        return null;
    }

    /* mapToInt()
    @param ToIntFunction（#applyAsInt)
    @return IntStream */
    public Double CalculateAverageAgeOfMiddleAdult() {
        return null;
    }

    /* collect()
    @param Collector
    @return Collection

    Collectors.groupingBy: @return Collector*/
    public Map<String, List<Person>> groupByFirstLetter() {
        return null;
    }

    //将姓名首字母大写
    private String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
