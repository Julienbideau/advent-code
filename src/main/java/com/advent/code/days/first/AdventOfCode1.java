package com.advent.code.days.first;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AdventOfCode1 {

    public Integer returnMaximumCaloriesCarriedByElve(List<Elve> elves){
      return elves.stream().map(this::sumOfCaroliesByElves).mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
    }

    public Integer returnBest3ElvesCarriyingMaxCalories(List<Elve> elves){
        final List<Elve> best3 = elves.stream().sorted(Comparator.comparing(this::sumOfCaroliesByElves).reversed()).limit(3).collect(Collectors.toList());
        return best3.stream().map(this::sumOfCaroliesByElves).mapToInt(v -> v).sum();
    }

    private Integer sumOfCaroliesByElves(Elve elve){
        return elve.getItemsCarried().stream().map(Items::getCalories).reduce(0, Integer::sum);
    }
}
