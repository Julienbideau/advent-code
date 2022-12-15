package com.advent.code.days.seventh;

import com.advent.code.common.Runner;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode7Test {
    public AdventOfCode7 adventOfCode7 = new AdventOfCode7();
    public Runner runner = new Runner();

    public AdventOfCode7Test() {
    }

    @Test
    public void shouldBeOkWithSample() throws IOException {
        InputValue input = runner.run(new Parser(), "7/input_sample.txt");
        Integer totalSize = input.getTotalSize(input.getDirectories());
        assertEquals(95437, totalSize);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        InputValue input = runner.run(new Parser(), "7/input.txt");
        Integer totalSize = input.getTotalSize(input.getDirectories());
        assertEquals(533151, totalSize);
    }
}