package com.advent.code;

import com.advent.code.common.AdventOfCodeParser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Runner {

    public <T> InputValue run(AdventOfCodeParser<T> inputValueParser, String inputFileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        final String inputFolderPath = "advent/"+inputFileName;
        final URL resource = classLoader.getResource(inputFolderPath);
        final File inputFile = new File(Objects.requireNonNull(resource).getFile());

        final Scanner scanner = new Scanner(inputFile);
        final T inputValue = inputValueParser.parse(scanner);
        return (InputValue) inputValue;
    }
}
