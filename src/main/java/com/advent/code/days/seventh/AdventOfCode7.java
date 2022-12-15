package com.advent.code.days.seventh;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AdventOfCode7 {

    public String moveFromInstructions(String[][] stacks, List<Instruction> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            System.out.println("Instruction line count : " + i);
            System.out.println("Instruction : " + instruction);
            if (i == 48) {
                System.out.println("Instruction line count : " + i);
            }
            for (int j = 0; j < instruction.getMovesCount(); j++) {
                doMove(stacks, instruction.getFrom(), instruction.getTo());
            }
        }
        String result = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < stacks.length; j++) {
                if (stacks[j][i] != null && !Objects.equals(stacks[j][i], "") && !Objects.equals(stacks[j][i], " ")) {
                    result = result + stacks[j][i];
                    break;
                }
            }

        }
        return result;
    }

    public String moveFromInstructionsMultiples(String[][] stacks, List<Instruction> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            System.out.println("Instruction line count : " + i);
            System.out.println("Instruction : " + instruction);
            if (i == 48) {
                System.out.println("Instruction line count : " + i);
            }
            doMultipleMoves(stacks, instruction.getFrom(), instruction.getTo(), instruction.getMovesCount());
        }
        String result = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < stacks.length; j++) {
                if (stacks[j][i] != null && !Objects.equals(stacks[j][i], "") && !Objects.equals(stacks[j][i], " ")) {
                    result = result + stacks[j][i];
                    break;
                }
            }

        }
        return result;
    }

    public void doMove(String[][] stacks, Integer from, Integer to) {
        String[] fromColumn = Arrays.stream(stacks).map(x -> x[from - 1]).filter(Objects::nonNull).filter(s -> !"".equals(s)).filter(s -> !" ".equals(s)).toArray(String[]::new);
        if (fromColumn.length == 0) {
            return;
        }
        String s = fromColumn[0];

        handleFrom(stacks, from);
        handleTo(stacks, to, s);
        System.out.println(Arrays.deepToString(stacks).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace("null", ""));
    }

    public void doMultipleMoves(String[][] stacks, Integer from, Integer to, Integer movesCount) {
        String[] fromColumn = Arrays.stream(stacks).map(x -> x[from - 1]).filter(Objects::nonNull).filter(s -> !"".equals(s)).filter(s -> !" ".equals(s)).toArray(String[]::new);
        if (fromColumn.length == 0) {
            return;
        }
        for (int i = movesCount; i > 0; i--) {
            String crateToMove = fromColumn[i - 1];
            handleFromMultiple(stacks, from, i - 1);
            handleTo(stacks, to, crateToMove);
        }

        System.out.println(Arrays.deepToString(stacks).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace("null", ""));
    }

    private static void handleTo(String[][] stacks, Integer to, String s) {
        for (int i = 0; i < stacks.length; i++) {
            for (int j = 0; j < stacks.length; j++) {
                if (j == to - 1) {
                    if (stacks[i][j] != null && !Objects.equals(stacks[i][j], "") && !Objects.equals(stacks[i][j], " ")) {
                        stacks[i - 1][j] = s;
                        return;
                    }
                }
            }
        }
        boolean foundEmptyString = false;
        for (int i = 0; i < stacks.length; i++) {
            for (int j = 0; j < stacks.length; j++) {
                if (j == to - 1) {
                    if (stacks[i][j] == null && foundEmptyString) {
                        stacks[i - 1][j] = s;
                        return;
                    }
                    if (stacks[i][j] == "") {
                        foundEmptyString = true;
                    }
                }
            }
        }
    }

    private static void handleFrom(String[][] stacks, Integer from) {
        for (int i = 0; i < stacks.length; i++) {
            for (int j = 0; j < stacks.length; j++) {
                if (j == from - 1) {
                    if (stacks[i][j] != null && stacks[i][j] != "" && !Objects.equals(stacks[i][j], " ")) {
                        stacks[i][j] = "";
                        return;
                    }
                }
            }
        }
    }

    private static void handleFromMultiple(String[][] stacks, Integer from, Integer index) {
        for (int i = 0; i < stacks.length; i++) {
            for (int j = 0; j < stacks.length; j++) {
                if (j == from - 1) {
                    if (stacks[i][j] != null && stacks[i][j] != "" && !Objects.equals(stacks[i][j], " ")) {
                        stacks[i + index][j] = "";
                        return;
                    }
                }
            }
        }
    }

}
