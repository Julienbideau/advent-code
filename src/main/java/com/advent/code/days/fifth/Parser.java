package com.advent.code.days.fifth;

import com.advent.code.common.AdventOfCodeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements AdventOfCodeParser<InputValue> {

    public Parser() {
    }

    public InputValue parse(Scanner scanner) {
        String[][] stacks = new String[100][10];
        List<Instruction> instructions = new ArrayList<>();
        boolean parseCratesStacks = true;
        int lineNumber = 0;
        while (scanner.hasNext()) {
            if (parseCratesStacks) {
                String cratesStacksLine = scanner.nextLine();
                if (Objects.equals(cratesStacksLine, "")) {
                    parseCratesStacks = false;
                    continue;
                }
                char c1 = cratesStacksLine.charAt(1);
                if (Character.isDigit(c1)) {
                    continue;
                }
                String c = String.valueOf(c1);
                stacks[lineNumber + 90][0] = c;

                for (int i = 5; i < cratesStacksLine.length(); i = i + 4) {
                    stacks[lineNumber + 90][(i - 1) / 4] = String.valueOf(cratesStacksLine.charAt(i));

                }
                lineNumber++;
            } else {
                Instruction instruction = new Instruction();
                String instructionsLine = scanner.nextLine();
                Pattern patternMoves = Pattern.compile("move (.*) from");
                Matcher matcherMoves = patternMoves.matcher(instructionsLine);
                if (matcherMoves.find()) {
                    String moves = matcherMoves.group(1);
                    instruction.setMovesCount(Integer.parseInt(moves));
                }

                Pattern pattern = Pattern.compile("from (.*) to");
                Matcher matcher = pattern.matcher(instructionsLine);
                if (matcher.find()) {
                    String from = matcher.group(1);
                    instruction.setFrom(Integer.parseInt(from));
                }
                Pattern patternTo = Pattern.compile("to (.*)");
                Matcher matcherTo = patternTo.matcher(instructionsLine);
                if (matcherTo.find()) {
                    String to = matcherTo.group(1);
                    instruction.setTo(Integer.parseInt(to));
                }
                String.valueOf(instructionsLine.charAt(5));
                instructions.add(instruction);
                // parse instructions
            }
        }

        return new InputValue(stacks, instructions);
    }
}
