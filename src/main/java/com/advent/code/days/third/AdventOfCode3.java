package com.advent.code.days.third;

import java.util.ArrayList;
import java.util.List;

public class AdventOfCode3 {

    public List<Character> returnCommonLetters(List<RuckSacks> ruckSacks) {
        return ruckSacks.stream().map(this::getCommonLetter).toList();
    }

    public List<Character> returnCommonLettersByGroupOf3RuckSacks(List<RuckSacks> ruckSacks) {
        List<List<RuckSacks>> rucksacksBy3 = new ArrayList<>();
        for (int i = 0; i < ruckSacks.size(); i += 3) {
            int end = Math.min(ruckSacks.size(), i + 3);
            rucksacksBy3.add(ruckSacks.subList(i, end));
        }
        return rucksacksBy3.stream().map(this::getCommonLetterFor3Rucksacks).toList();
    }

    private Character getCommonLetter(RuckSacks ruckSacks) {
        String first = ruckSacks.getItems().get(0);
        String second = ruckSacks.getItems().get(1);
        Character commonLetter = first.chars().mapToObj((c) -> (char) c).filter(letter -> isInRightItem(letter, second)).findFirst().orElseThrow(IllegalStateException::new);
        return commonLetter;
    }


    private Character getCommonLetterFor3Rucksacks(List<RuckSacks> ruckSacks) {
        String firstOne = ruckSacks.stream()
                .map(RuckSacks::getItems)
                .findFirst()
                .orElseThrow(IllegalStateException::new)
                .stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        Character commonLetter = firstOne.chars().mapToObj(c -> (char) c).filter(letter -> isInAllRucksacks(letter, ruckSacks.stream().skip(1).toList())).findFirst().orElseThrow(IllegalStateException::new);
        return commonLetter;
    }

    private Boolean isInRightItem(Character letter, String right) {
        return right.chars().mapToObj((c) -> (char) c
        ).anyMatch((a) -> a.equals(letter));
    }

    private Boolean isInAllRucksacks(Character letter, List<RuckSacks> otherRucksacks) {
        return otherRucksacks
                .stream()
                .map(RuckSacks::getItems)
                .flatMap(List::stream)
                .allMatch(item -> item.chars().mapToObj(c -> (char) c).anyMatch(a -> a.equals(letter)));

    }
}
