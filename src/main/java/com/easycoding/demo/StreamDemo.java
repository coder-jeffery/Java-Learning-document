package com.easycoding.javaDataStructure.resource.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/26$
 **/

/**
 * 函数接口:
 *      Predicate<T>
 *      Consumer<T>
 *      Function<T,R>
 *      Supplier<T>
 *      UnaryOperator<T>
 *      BinaryOperator<T>
 * */
public class StreamDemo {
    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("a", "b");
        System.out.println(stringStream);

        List<String> collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(toList());

        Stream<String> strStream = Stream.of("Hello Aron.");
        Stream<String[]> stringArrayStream = strStream.map(word -> word.split(" "));

        System.out.println("testing...");

        // 筛选年龄大于19的学生
//        List<Student> stu = Stream.of(new Student("zhangSan", 19), new Student("liSi"), 20)
//                .filter(Student -> Student.getAge() > 19)
//                .collect(toList());
//        Supplier<Student> s = Student::new;

//        Random random = new Random();
//        Stream<Integer> stream = Stream.generate(() ->random.nextInt(1));
//        stream.forEach(t -> System.out.println(t));

        HashMap<String,Double> map = new HashMap<>();
        map.put("周瑜",9000.0);
        map.put("宋江",12000.0);
        map.put("张飞",8000.0);

        map.forEach((k,v) -> {
            if (v < 10000.0)
                map.put(k,10000.0);
        });//BiConsumer<T,U>，void apply(T t, U u)
        map.forEach((k,v) -> System.out.print(k + ":" + v + "\t\t"));
    }
}

@Data
class Student {

    public int age;
    public String name;

    public Student(String liSi) {

    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
