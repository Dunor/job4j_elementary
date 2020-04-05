package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
   public List<Student> collect(List<Student> students, Predicate<Student> predict) {
       List<Student> res = students.stream().filter(predict).collect(Collectors.toList());
       return res;
   }

    public Map<String, Student> listToMap(List<Student> students) {
        Map<String, Student> res = students.stream().collect(Collectors.toMap(Student::getName, e -> e));
        return res;
    }
}
