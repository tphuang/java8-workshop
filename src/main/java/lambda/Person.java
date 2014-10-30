package lambda;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //打印Person信息
    public void showPerson() {
        System.out.println(String.format("\t%-8s %s", name, age));
    }

    public String getFirstLetter() {
        return this.name.substring(0, 1);
    }

    //重写equals接口，测试验证的时候可以只比较对象的值,如assertThat(result, is(expectedResult));
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;

        return true;
    }
}
