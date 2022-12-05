package com.advent.code.days.third;

import com.advent.code.common.AdventOfCodeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserPart2 implements AdventOfCodeParser<InputValue> {

    public ParserPart2() {
    }

    public InputValue parse(Scanner scanner) {
        List<RuckSacks> ruckSacks = new ArrayList();

        while (scanner.hasNext()) {
            String item = scanner.nextLine();
            ruckSacks.add(new RuckSacks(List.of(item)));
        }

        return new InputValue(ruckSacks);
    }
}
