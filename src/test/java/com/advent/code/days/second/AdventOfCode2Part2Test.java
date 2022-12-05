package com.advent.code.days.second;

import com.advent.code.common.Runner;
import com.advent.code.days.first.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode2Part2Test {

    public AdventOfCode2 adventOfCode2 = new AdventOfCode2();
    public com.advent.code.common.Runner runner = new Runner();


    @Test
    public void shouldBeOkWithSample() throws IOException {
        final List<InputValue> inputs = runner.run(new Parser(), "2/input_sample.txt");
        final Integer totalScoreOfGame2 = adventOfCode2.getTotalScoreOfGame2(inputs);
        assertEquals(12, totalScoreOfGame2);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        final List<InputValue> inputs = runner.run(new Parser(), "2/input.txt");
        final Integer totalScoreOfGame2 = adventOfCode2.getTotalScoreOfGame2(inputs);
        assertEquals(16098, totalScoreOfGame2);
    }

}
