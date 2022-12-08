package com.advent.code.days.forth;

import com.advent.code.common.Runner;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode4Test {
    public AdventOfCode5 adventOfCode4 = new AdventOfCode5();
    public Runner runner = new Runner();

    public AdventOfCode4Test() {
    }

    @Test
    public void shouldBeOkWithSample() throws IOException {
        InputValue input = runner.run(new Parser(), "4/input_sample.txt");
        long pairsFullyContainedByOtherOneTotal = this.adventOfCode4.countPairsFullyContainsByOther(input.getPairs());
        assertEquals(2, pairsFullyContainedByOtherOneTotal);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        InputValue input = runner.run(new Parser(), "4/input.txt");
        long pairsFullyContainedByOtherOneTotal = this.adventOfCode4.countPairsFullyContainsByOther(input.getPairs());
        assertEquals(580, pairsFullyContainedByOtherOneTotal);
    }
}