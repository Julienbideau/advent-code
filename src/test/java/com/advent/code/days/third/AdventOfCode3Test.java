package com.advent.code.days.third;

import com.advent.code.common.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AdventOfCode3Test {
    public AdventOfCode3 adventOfCode3 = new AdventOfCode3();
    public Runner runner = new Runner();

    public AdventOfCode3Test() {
    }

    @Test
    public void shouldBeOkWithSample() throws IOException {
        InputValue input = runner.run(new Parser(), "3/input_sample.txt");
        List<Character> maximumCaloriesCarriedByElve = this.adventOfCode3.returnCommonLetters(input.getRuckSacks());
        int[] lettersInAscii = maximumCaloriesCarriedByElve.stream().mapToInt((character) -> character).toArray();
        int[] intInMinus = Arrays.stream(lettersInAscii).filter((integer) -> integer > 96).map((integer) -> integer - 96).toArray();
        int[] intInMaj = Arrays.stream(lettersInAscii).filter((integer) -> integer <= 96).map((integer) -> integer - 38).toArray();
        Assertions.assertEquals(157, Arrays.stream(intInMaj).sum() + Arrays.stream(intInMinus).sum());
    }

    @Test
    public void shouldBeOkWithRightInput() throws IOException {
        InputValue input = runner.run(new Parser(), "3/input.txt");
        List<Character> maximumCaloriesCarriedByElve = adventOfCode3.returnCommonLetters(input.getRuckSacks());
        int[] lettersInAscii = maximumCaloriesCarriedByElve.stream().mapToInt((character) -> character).toArray();
        int[] intInMinus = Arrays.stream(lettersInAscii).filter((integer) -> integer > 96).map((integer) -> integer - 96).toArray();
        int[] intInMaj = Arrays.stream(lettersInAscii).filter((integer) -> integer <= 96).map((integer) -> integer - 38).toArray();
        Assertions.assertEquals(7742, Arrays.stream(intInMaj).sum() + Arrays.stream(intInMinus).sum());
    }
}