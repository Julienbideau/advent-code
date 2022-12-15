package com.advent.code.days.eighth;

import com.advent.code.common.Runner;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode8Test {
    public AdventOfCode8 adventOfCode8 = new AdventOfCode8();
    public Runner runner = new Runner();

    public AdventOfCode8Test() {
    }

    @Test
    public void shouldBeOkWithSample() throws IOException {
        Integer input = runner.run(new Parser(), "8/input_sample.txt");
        assertEquals(21, input);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        Integer input = runner.run(new Parser(), "8/input.txt");
        assertEquals(533151, input);
    }
}