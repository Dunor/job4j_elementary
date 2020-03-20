package ru.job4j.streamapi;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    School school = new School();
    List<Student> students;

    @Before
    public void before() {
        Student st1 = new Student(50);
        Student st2 = new Student(60);
        Student st3 = new Student(40);
        Student st4 = new Student(70);
        Student st5 = new Student(100);
        Student st6 = new Student(30);
        students = Arrays.asList(st1, st2, st3, st4, st5, st6);
    }
    @Test
    public void whenClassA() {
        Predicate<Student> predicate = x -> x.getScore() >= 70 && x.getScore() <= 100;
        List<Student> res = school.collect(students, predicate);
        List<Student> expected = Arrays.asList(students.get(3), students.get(4));
        assertThat(res, is(expected));
    }

    @Test
    public void whenClassB() {
        Predicate<Student> predicate = x -> x.getScore() >= 50 && x.getScore() < 70;
        List<Student> res = school.collect(students, predicate);
        List<Student> expected = Arrays.asList(students.get(0), students.get(1));
        assertThat(res, is(expected));
    }

    @Test
    public void whenClassC() {
        Predicate<Student> predicate = x -> x.getScore() > 0 && x.getScore() < 50;
        List<Student> res = school.collect(students, predicate);
        List<Student> expected = Arrays.asList(students.get(2), students.get(5));
        assertThat(res, is(expected));
    }
}