package com.advent.code;

import com.advent.code.common.AdventOfCodeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Parser implements AdventOfCodeParser<InputValue> {

    @Override
    public InputValue parse(Scanner scanner) {
        List<Elve> elves = new ArrayList<>();
        List<Items> items= new ArrayList<>();
        while (scanner.hasNext()){
            String calory = scanner.nextLine();
            if (!Objects.equals(calory, "")){
                items.add(new Items(Integer.parseInt(calory)));
                continue;
            }
            items = new ArrayList<>();
            elves.add(new Elve(items));
        }

        return new InputValue(elves);
    }
}