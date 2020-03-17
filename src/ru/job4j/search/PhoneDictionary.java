package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> isName = x -> x.getName().equals(key);
        Predicate<Person> isSurname = x -> x.getSurname().equals(key);
        Predicate<Person> isPhone = x -> x.getPhone().equals(key);
        Predicate<Person> isAddress = x -> x.getAddress().equals(key);

        Predicate<Person> combine = isName.or(isSurname).or(isPhone).or(isAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
