package com.advent.code.days.eighth;

import com.advent.code.common.Runner;
import com.advent.code.days.fifth.AdventOfCode5;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode8Part2Test {

    public AdventOfCode5 adventOfCode5 = new AdventOfCode5();
    public Runner runner = new Runner();

    public AdventOfCode8Part2Test() {
    }

    @Test
    public void shouldBeOkWithSample() throws IOException {
        Integer inputValue = runner.run(new Parser2(), "8/input_sample.txt");
        assertEquals(8, inputValue);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        Integer inputValue = runner.run(new Parser2(), "8/input.txt");
        assertEquals(21, inputValue);
    }
}