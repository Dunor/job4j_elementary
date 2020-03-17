package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(new Person("Maksim", "Kudryashov", "534872", "nsk"));
        ArrayList<Person> persons = phones.find("Maksim");
        assertThat(persons.get(0).getSurname(), is("Kudryashov"));
    }

}