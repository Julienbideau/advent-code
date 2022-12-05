package com.advent.code.days.second;

import com.advent.code.common.Runner;
import com.advent.code.days.first.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventOfCode2Test {

    public AdventOfCode2 adventOfCode2 = new AdventOfCode2();
    public com.advent.code.common.Runner runner = new Runner();


    @Test
    public void shouldBeOkWithSample() throws IOException {
        final List<InputValue> inputs = runner.run(new Parser(), "2/input_sample.txt");
        final Integer totalScore = adventOfCode2.getTotalScoreOfGame(inputs);
        assertEquals(15, totalScore);
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        final List<InputValue> inputs = runner.run(new Parser(), "2/input.txt");
        final Integer totalScore = adventOfCode2.getTotalScoreOfGame(inputs);
        assertEquals(15572, totalScore);
    }

}
