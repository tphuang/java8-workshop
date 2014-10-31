package lambda;

import java.util.List;
import java.util.Map;

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

    public List<Person> handleFilter() {
        return null;
    }

    public List<Person> handleSort() {
        return null;
    }


    public List<Person> handleCapitalize() {
        return null;
    }

    public Person selectPersonWithMaxAge() {
        return null;
    }

    public Double CalculateAverageAgeOfMiddleAdult() {
        return null;
    }

    public Map<String, List<Person>> groupByFirstLetter() {
        return null;
    }

    //将姓名首字母大写
    private String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
