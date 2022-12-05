package com.advent.code.days.third;

import com.advent.code.common.AdventOfCodeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser implements AdventOfCodeParser<InputValue> {

    public Parser() {
    }

    public InputValue parse(Scanner scanner) {
        List<RuckSacks> ruckSacks = new ArrayList();

        while(scanner.hasNext()) {
            String item = scanner.nextLine();
            String leftPart = item.substring(0, item.length() / 2);
            String rightPart = item.substring(item.length() / 2);
            List<String> items = List.of(leftPart, rightPart);
            ruckSacks.add(new RuckSacks(items));
        }

        return new InputValue(ruckSacks);
    }
}
