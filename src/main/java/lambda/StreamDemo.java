package lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
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
        Predicate<Person> predicate1 = p -> p.getAge() >= 18;
        Predicate<Person> predicate2 = p -> p.getAge() <= 50;
        return initData().stream() //包装成stream
//                .filter(p -> {
//                    return p.getAge() >= 18 && p.getAge() <= 50;
//                })
                .filter(predicate1.and(predicate2))
                        //stream转化为List
                .collect(Collectors.toList());
    }

    /* sorted()
    @param Comparator (#compare)
    @return Stream */
    public List<Person> handleSort() {
        Comparator<Person> comparator1 = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Comparator<Person> comparator2 = (p1, p2) -> p1.getAge() - p2.getAge();
        return initData().stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 50)
//                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()) == 0 ?
//                        p1.getAge() - p2.getAge() : p1.getName().compareTo(p2.getName()))
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .sorted(comparator1.thenComparing(comparator2))
                .collect(Collectors.toList());
    }

    /* map()
    @param Function<Person, Object> (#apply)
    @return Stream */
    public List<Person> handleCapitalize() {
        return handleSort().stream()
//                .map(p -> new Person(capitalize(p.getName()), p.getAge()))
                .map(new Function<Person, Person>() {
                    @Override
                    public Person apply(Person person) {
                        person.setName(capitalize(person.getName()));
                        return person;
                    }
                })
                .map(p -> {
                    p.setName(capitalize(p.getName()));
                    return p;
                })
//                .map(p -> new Person(capitalize(p.getName()), p.getAge()))
                .collect(Collectors.toList());
    }

    /* reduce()
    @param BinaryOperator<Person> （#apply）
    @return Optional */
    public Person selectPersonWithMaxAge() {
        return handleCapitalize().stream()
                .reduce((p1, p2) -> (p1.getAge() >= p2.getAge()) ? p1 : p2)
                .get();
    }

    /* mapToInt()
    @param ToIntFunction（#applyAsInt)
    @return IntStream */
    public Double CalculateAverageAgeOfMiddleAdult() {
        return handleCapitalize().stream()
                .mapToInt(Person::getAge)
                .average().getAsDouble();
    }

    /* collect()
    @param Collector
    @return Collection

    Collectors.groupingBy: @return Collector*/
    public Map<String, List<Person>> groupByFirstLetter() {
        Map<String, List<Person>> groupMap = handleCapitalize().stream()
                .collect(Collectors.groupingBy(Person::getFirstLetter));

        SortedMap sortedMap = new TreeMap<>();
        sortedMap.putAll(groupMap);
        return sortedMap;
    }

    //将姓名首字母大写
    private String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
