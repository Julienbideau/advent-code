package com.advent.code.days.first;

import com.advent.code.common.Runner;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode1Part2Test {

    public AdventOfCode1 adventOfCode1 = new AdventOfCode1();
    public Runner runner = new Runner();


    @Test
    public void shouldBeOkWithSample() throws IOException {
        final InputValue input = runner.run(new Parser(), "1/input_sample.txt");
        final Integer maximumCaloriesCarriedByElve = adventOfCode1.returnBest3ElvesCarriyingMaxCalories(input.getElves());
        assertEquals(45000, maximumCaloriesCarriedByElve);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        final InputValue input = runner.run(new Parser(), "1/input.txt");
        final Integer maximumCaloriesCarriedByElve = adventOfCode1.returnBest3ElvesCarriyingMaxCalories(input.getElves());
        assertEquals(193697, maximumCaloriesCarriedByElve);
    }

    @Test
    public void shouldBeOkWithOneElve() {
        final Elve e1 = new Elve(List.of(new Items(1)));
        final Elve e2 = new Elve(List.of(new Items(1), new Items(3)));
        final List<Elve> elves = List.of(e1,e2);
        final Integer maximumCaloriesCarriedByElve = adventOfCode1.returnMaximumCaloriesCarriedByElve(elves);
        assertEquals(4, maximumCaloriesCarriedByElve);
    }
}
