package com.advent.code.days.second;

import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;


public class Day02 {

    public static int evaluate(String strategy) {
        int score = 0;
        String[] choices = strategy.split(" ");
        int otherChoice = choices[0].compareTo("A");
        int myChoice = choices[1].compareTo("X");
        int diffMod3 = Math.floorMod((otherChoice - myChoice),3);
        //System.out.println(diffMod3);
        switch(diffMod3) {
            case 0: score += 3; break;
            case 1: break;
            case 2: score += 6; break;
        }
        score += myChoice + 1;
        return score;
    }

    public static void part1() throws IOException {
        ClassLoader classLoader = Day02.class.getClassLoader();
        final String inputFolderPath = "advent/days/2/input.txt";
        final URL resource = classLoader.getResource(inputFolderPath);
        final File inputFile = new File(Objects.requireNonNull(resource).getFile());
        Scanner in = new Scanner(inputFile);
        int total = 0;
        while(in.hasNext()) {
            String line = in.nextLine();
            //System.out.println(line);
            total += evaluate(line);
        }
        System.out.println(total);
    }

    public static void part2() {

    }

    public static void main(String...args) {
        try {
            part1();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}