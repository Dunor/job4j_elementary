package ru.job4j.streamapi;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {

    @Test
    public void whenMatrixToList() {
        Converter convert = new Converter();
        Integer[][] matrix = {{2, 3}, {5, 5}};
        List<Integer> res = convert.MatrixToList(matrix);
        List<Integer> expected = List.of(2, 3, 5, 5);
        assertThat(res, is(expected));
    }
}