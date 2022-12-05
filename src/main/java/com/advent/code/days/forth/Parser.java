package com.advent.code.days.forth;

import com.advent.code.common.AdventOfCodeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser implements AdventOfCodeParser<InputValue> {

    public Parser() {
    }

    public InputValue parse(Scanner scanner) {
        List<Pair> pairs = new ArrayList();

        while (scanner.hasNext()) {
            String pairLine = scanner.nextLine();
            String[] pairArray = pairLine.split(",");
            Pair pair = new Pair(new Assignment(Integer.parseInt(pairArray[0].split("-")[0]), Integer.parseInt(pairArray[0].split("-")[1])),
                    new Assignment(Integer.parseInt(pairArray[1].split("-")[0]), Integer.parseInt(pairArray[1].split("-")[1])));
            pairs.add(pair);
        }

        return new InputValue(pairs);
    }
}
