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

    /*Demo需求：
    有个Person对象，该对象有name和age属性。当我们初始化一些人的信息后，对这些人进行如下操作：
    1. 选出18岁到50岁的所有中年人；
    2. 在1的基础上，先按姓名的字典顺序排序，再按年龄大小升序排序；
    3. 在2的基础上，将姓名首字母大写；
    4. 在3的基础上，选出年龄最大的Person对象；
    5. 在3的基础上，计算所有中年人的年龄平均值；
    6. 在3的基础上，按姓名的首字母分组。*/

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
