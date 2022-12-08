package com.advent.code.days.fifth;

import com.advent.code.common.Runner;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode5Test {
    public AdventOfCode5 adventOfCode5 = new AdventOfCode5();
    public Runner runner = new Runner();

    public AdventOfCode5Test() {
    }

    @Test
    public void shouldBeOkWithSample() throws IOException {
        InputValue input = runner.run(new Parser(), "5/input_sample.txt");
        String result = adventOfCode5.moveFromInstructions(input.stacks, input.getInstructions());
        assertEquals("CMZ", result);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        InputValue input = runner.run(new Parser(), "5/input.txt");
        String result = adventOfCode5.moveFromInstructions(input.stacks, input.getInstructions());
        assertEquals("CMZ", result);
    }
}