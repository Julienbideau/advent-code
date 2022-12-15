package com.advent.code.days.seventh;

import com.advent.code.common.Runner;
import com.advent.code.days.fifth.AdventOfCode5;
import com.advent.code.days.fifth.InputValue;
import com.advent.code.days.fifth.Parser;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AdventOfCode6Part2Test {

    public AdventOfCode5 adventOfCode5 = new AdventOfCode5();
    public Runner runner = new Runner();

    public AdventOfCode6Part2Test() {
    }

    @Test
    public void shouldBeOkWithSample() throws IOException {
        InputValue inputValue = runner.run(new Parser(), "5/input_sample.txt");

    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        InputValue inputValue = runner.run(new Parser(), "5/input.txt");

    }
}