package com.advent.code.common;

import com.advent.code.common.AdventOfCodeParser;
import com.advent.code.days.first.InputValue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Runner {

    public <T> T run(AdventOfCodeParser<T> inputValueParser, String inputFileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        final String inputFolderPath = "advent/days/"+inputFileName;
        final URL resource = classLoader.getResource(inputFolderPath);
        final File inputFile = new File(Objects.requireNonNull(resource).getFile());

        final Scanner scanner = new Scanner(inputFile);
        final T inputValue = inputValueParser.parse(scanner);
        return inputValue;
    }
}
