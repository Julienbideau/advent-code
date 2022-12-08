package com.advent.code.days.fifth;

import com.advent.code.common.Runner;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode5Part2Test {

    public AdventOfCode5 adventOfCode5 = new AdventOfCode5();
    public Runner runner = new Runner();

    public AdventOfCode5Part2Test() {
    }

    @Test
    public void shouldBeOkWithSample() throws IOException {
        InputValue inputValue = runner.run(new Parser(), "5/input_sample.txt");
        String result = adventOfCode5.moveFromInstructionsMultiples(inputValue.stacks, inputValue.getInstructions());
        assertEquals("MCD", result);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        InputValue inputValue = runner.run(new Parser(), "5/input.txt");
        String result = adventOfCode5.moveFromInstructionsMultiples(inputValue.stacks, inputValue.getInstructions());
        assertEquals("CMZ", result);
    }
}