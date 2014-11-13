package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambda {

    public static void runThreadUseLambda() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名类实现的线程");
            }
        }).start();

        //Runnable是一个函数接口，返回void的run方法，所以lambda表达式左边没有参数
        new Thread(() -> System.out.println("lambda实现的线程")).start();
    }

    public List<String> initNames() {
        return Arrays.asList("Peter", "Anna", "Williams", "Mike");
    }

    public List<String> compareWithOldMethod() {
        List<String> names = initNames();
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        return names;
    }

    public List<String> compareWithLambda() {
        List<String> names = initNames();
        return names;
    }
}