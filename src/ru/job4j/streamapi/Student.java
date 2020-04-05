package ru.job4j.streamapi;

public class Student {
    private int score;
    private String name;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", score='" + score + '\'' +
                '}';
    }
}
