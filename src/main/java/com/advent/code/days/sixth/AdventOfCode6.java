package com.advent.code.days.sixth;

public class AdventOfCode6 {

    public Integer returnMarkerIndex(String input, Integer markerSize) {
        char[] chars = input.toCharArray();
        int indexMarker = 0;
        int differentCharsCount = 0;
        for (int i = 13; i < chars.length - 3; i++) {
            if (chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5] && chars[i] != chars[i - 6] && chars[i] != chars[i - 7] && chars[i] != chars[i - 8] && chars[i] != chars[i - 9] && chars[i] != chars[i - 10] && chars[i] != chars[i - 11] && chars[i] != chars[i - 12] && chars[i] != chars[i - 13]) {
                differentCharsCount++;
                if (differentCharsCount >= 10) {
                    System.out.println(" " + String.valueOf(chars[i - 13]) + String.valueOf(chars[i - 12]) + String.valueOf(chars[i - 11]) + String.valueOf(chars[i - 10]) + chars[i - 9] + chars[i - 8] + chars[i - 7] + chars[i - 6] + chars[i - 5] + chars[i - 4] + chars[i - 3] + chars[i - 2] + chars[i - 1] + chars[i]);
                    System.out.println("Got " + differentCharsCount + " chars at index: " + i);
                }
            } else if (differentCharsCount == 1 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5] && chars[i] != chars[i - 6] && chars[i] != chars[i - 7] && chars[i] != chars[i - 8] && chars[i] != chars[i - 9] && chars[i] != chars[i - 10] && chars[i] != chars[i - 11] && chars[i] != chars[i - 12]) {
                differentCharsCount++;
            } else if (differentCharsCount == 2 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5] && chars[i] != chars[i - 6] && chars[i] != chars[i - 7] && chars[i] != chars[i - 8] && chars[i] != chars[i - 9] && chars[i] != chars[i - 10] && chars[i] != chars[i - 11]) {
                differentCharsCount++;
            } else if (differentCharsCount == 3 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5] && chars[i] != chars[i - 6] && chars[i] != chars[i - 7] && chars[i] != chars[i - 8] && chars[i] != chars[i - 9] && chars[i] != chars[i - 10]) {
                differentCharsCount++;
            } else if (differentCharsCount == 4 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5] && chars[i] != chars[i - 6] && chars[i] != chars[i - 7] && chars[i] != chars[i - 8] && chars[i] != chars[i - 9]) {
                differentCharsCount++;
            } else if (differentCharsCount == 5 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5] && chars[i] != chars[i - 6] && chars[i] != chars[i - 7] && chars[i] != chars[i - 8]) {
                differentCharsCount++;
            } else if (differentCharsCount == 6 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5] && chars[i] != chars[i - 6] && chars[i] != chars[i - 7]) {
                differentCharsCount++;
            } else if (differentCharsCount == 7 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5] && chars[i] != chars[i - 6]) {
                differentCharsCount++;
            } else if (differentCharsCount == 8 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4] && chars[i] != chars[i - 5]) {
                differentCharsCount++;
            } else if (differentCharsCount == 9 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3] && chars[i] != chars[i - 4]) {
                differentCharsCount++;
            } else if (differentCharsCount == 10 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2] && chars[i] != chars[i - 3]) {
                differentCharsCount++;
            } else if (differentCharsCount == 11 && chars[i] != chars[i - 1] && chars[i] != chars[i - 2]) {
                differentCharsCount++;
            } else if (differentCharsCount == 12 && chars[i] != chars[i - 1]) {
                differentCharsCount++;
            } else if (differentCharsCount == 13) {
                differentCharsCount++;
            } else {
                differentCharsCount = 0;
            }

            if (differentCharsCount == markerSize) {
                System.out.println(" " + String.valueOf(chars[i - 13]) + String.valueOf(chars[i - 12]) + String.valueOf(chars[i - 11]) + String.valueOf(chars[i - 10]) + " " + chars[i - 9] + chars[i - 8] + chars[i - 7] + chars[i - 6] + chars[i - 5] + chars[i - 4] + chars[i - 3] + chars[i - 2] + chars[i - 1] + chars[i]);
                indexMarker = i + 1;
                break;
            }

        }
        return indexMarker;
    }

}
