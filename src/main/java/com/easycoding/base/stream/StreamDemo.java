package com.easycoding.base.stream;

import lombok.Builder;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<Student> students =   new ArrayList<>();
    }
}

class ExcellentStudent{
    String name;
    int location;
}

// stream
@ToString
@Builder
class Student{
    String name;
    int age;
    String address;
}
