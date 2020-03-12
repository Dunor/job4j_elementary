package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FunctionsTest {

    @Test
    public void whenLinearFunction() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * x * x + 7*x + 3);
        List<Double> expected = Arrays.asList(88D, 117D, 150D);
        assertThat(result, is(expected));
    }

@Test
    public void whenLogarithmicFunction() {
        List<Double> result = Functions.diapason(5, 8, x -> Math.log10(x));
        List<Double> expected = Arrays.asList(0.6989700043360189, 0.7781512503836436, 0.8450980400142568);
        assertThat(result, is(expected));
    }


}