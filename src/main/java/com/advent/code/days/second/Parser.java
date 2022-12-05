package com.advent.code.days.second;

import com.advent.code.common.AdventOfCodeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Parser implements AdventOfCodeParser<List<InputValue>> {

    @Override
    public List<InputValue> parse(Scanner scanner) {
        List<InputValue> inputs = new ArrayList<>();
        while (scanner.hasNext()){
            String[] line = scanner.nextLine().split(" ");
            InputValue inputValue = new InputValue((getOpponentChoice(line[0])), getOurChoice(line[1]));
            inputs.add(inputValue);
        }
        return inputs;
    }

    private RockScissorsPaper getOpponentChoice(String input){
        return switch (input){
            case "A" -> RockScissorsPaper.ROCK;
            case "B" -> RockScissorsPaper.PAPER;
            case "C" -> RockScissorsPaper.SCISSORS;
            default -> RockScissorsPaper.ROCK;
        };
    }

    private RockScissorsPaper getOurChoice(String input){
        return switch (input){
            case "X" -> RockScissorsPaper.ROCK;
            case "Y" -> RockScissorsPaper.SCISSORS;
            case "Z" -> RockScissorsPaper.PAPER;
            default -> RockScissorsPaper.ROCK;
        };
    }
}