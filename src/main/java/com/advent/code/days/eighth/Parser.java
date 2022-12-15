package com.advent.code.days.eighth;

import com.advent.code.common.AdventOfCodeParser;
import com.advent.code.days.seventh.Directory;
import com.advent.code.days.seventh.InputValue;

import java.util.Scanner;

public class Parser implements AdventOfCodeParser<Integer> {

    private static Directory currentDirectory = new Directory("/");
    private static InputValue inputValue = new InputValue();

    public Parser() {
    }

    public Integer parse(Scanner scanner) {

        String s = scanner.nextLine();
        String[] sizes = s.split(" ");

        int countTrees = 0;
        boolean firstLine = true;
        Integer[][] treesSizes = new Integer[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        int lineNumber = 0;
        scanner.reset();
        while (scanner.hasNext()) {
            char[] string = scanner.nextLine().toCharArray();
            // declaring an array with the size of string
            Integer[] arr = new Integer[string.length];
            for (int i = 0; i < string.length; i++) {
                arr[i] = Character.getNumericValue(string[i]);
            }
            treesSizes[lineNumber] = arr;
            if (firstLine || !scanner.hasNext()) {
                countTrees = countTrees + arr.length;
            } else {
                countTrees = countTrees + 2;
            }
            firstLine = false;
            lineNumber++;
        }

        for (int i = 1; i < treesSizes.length - 1; i++) {
            for (int j = 1; j < treesSizes[i].length - 1; j++) {
                Integer treeSize = treesSizes[i][j];
                if (isVisible(treeSize, treesSizes, i, j)) {
                    countTrees++;
                }
            }
        }

        return countTrees;
    }

    private boolean isVisible(int treeSize, Integer[][] treesSizes, int i, int j) {
        for (int k = j + 1; k < treesSizes[i].length; k++) {
            if (treeSize <= treesSizes[i][k]) {
                break;
            }
            if (k == treesSizes[i].length - 1) {
                return true;
            }
        }

        for (int k = j - 1; k >= 0; k--) {
            if (treeSize <= treesSizes[i][k]) {
                break;
            }
            if (k == 0) {
                return true;
            }
        }
        for (int k = i + 1; k < treesSizes.length; k++) {
            if (treeSize <= treesSizes[k][j]) {
                break;
            }
            if (k == treesSizes[i].length - 1) {
                return true;
            }
        }
        for (int k = i - 1; k >= 0; k--) {
            if (treeSize <= treesSizes[k][j]) {
                break;
            }
            if (k == 0) {
                return true;
            }
        }
        return false;
    }
}
