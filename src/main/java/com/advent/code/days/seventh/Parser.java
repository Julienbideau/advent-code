package com.advent.code.days.seventh;

import com.advent.code.common.AdventOfCodeParser;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements AdventOfCodeParser<InputValue> {

    private static Directory currentDirectory = new Directory("/");
    private static InputValue inputValue = new InputValue();

    public Parser() {
    }

    public InputValue parse(Scanner scanner) {

        while (scanner.hasNext()) {
            executeCommand(scanner);
        }
        inputValue.fillSize(inputValue.directories);
        inputValue.sumSizes(inputValue.directories);
        return inputValue;
    }

    private static void executeCommand(Scanner scanner) {
        String s = scanner.nextLine();

        if (s.startsWith("$")) {
            if (s.contains("cd")) {
                // move
                Pattern patternMoves = Pattern.compile("cd (.*)");
                Matcher matcherMoves = patternMoves.matcher(s);
                if (matcherMoves.find()) {
                    //    currentDirectory = matcherMoves.group(1);
                    System.out.println("CD" + matcherMoves.group(1));
                    if (inputValue.directories != null) {
                        if ("..".equals(matcherMoves.group(1))) {
                            System.out.println("COUCOU2");
                            currentDirectory = inputValue.findParentDirectoryByName(currentDirectory.name, inputValue.directories);
                        } else {
                            currentDirectory = inputValue.findDirectoryByName(matcherMoves.group(1), currentDirectory.childrens, inputValue.directories);
                        }
                        System.out.println("current directory : " + currentDirectory);
                    }

                }

            }
            if (s.contains("ls")) {
                while (scanner.hasNext()) {
                    String s1 = scanner.nextLine();
                    System.out.println(s1);
                    if (s1.startsWith("$")) {
                        if (s1.contains("cd")) {
                            System.out.println("start recursive");
                            // move
                            System.out.println("CD");
                            Pattern patternMoves = Pattern.compile("cd (.*)");
                            Matcher matcherMoves = patternMoves.matcher(s1);
                            if (matcherMoves.find()) {
                                if ("..".equals(matcherMoves.group(1))) {
                                    System.out.println("COUCOU");
                                    currentDirectory = inputValue.findParentDirectoryByName(currentDirectory.name, inputValue.directories);
                                } else {
                                    currentDirectory = inputValue.findDirectoryByName(matcherMoves.group(1), currentDirectory.childrens, inputValue.directories);
                                }

                                System.out.println("current directory : " + currentDirectory);
                            }
                            // move
                            executeCommand(scanner);
                            return;
                        }
                    }
                    if (Objects.equals(currentDirectory.name, "/")) {
                        if (s1.startsWith("dir")) {
                            Pattern patternMoves = Pattern.compile("dir (.*)");
                            Matcher matcherMoves = patternMoves.matcher(s1);
                            if (matcherMoves.find()) {
                                //currentDirectory = matcherMoves.group(1);
                                System.out.println("current directory : " + currentDirectory);
                                inputValue.addDirectory(new Directory(matcherMoves.group(1)));

                            }
                        } else {
                            // FILE
                            Pattern patternSize = Pattern.compile("(.*) ");

                            Pattern patternName = Pattern.compile(" (.*)");
                            Matcher matcherMoves = patternSize.matcher(s1);
                            Matcher matcherName = patternName.matcher(s1);
                            if (s1.startsWith("$")) {
                                continue;
                            }
                            if (matcherMoves.find() && matcherName.find()) {
                                currentDirectory.addFile(new File(matcherName.group(1), Integer.parseInt(matcherMoves.group(1))));
                            }
                        }

                    } else {
                        if (s1.startsWith("dir")) {
                            Pattern patternMoves = Pattern.compile("dir (.*)");
                            Matcher matcherMoves = patternMoves.matcher(s1);
                            if (matcherMoves.find()) {
                                currentDirectory.addChildren(new Directory(matcherMoves.group(1)));
                            }
                        } else {
                            // FILE
                            Pattern patternSize = Pattern.compile("(.*) ");

                            Pattern patternName = Pattern.compile(" (.*)");
                            Matcher matcherMoves = patternSize.matcher(s1);
                            Matcher matcherName = patternName.matcher(s1);
                            if (s1.startsWith("$")) {
                                continue;
                            }
                            if (matcherMoves.find() && matcherName.find()) {
                                currentDirectory.addFile(new File(matcherName.group(1), Integer.parseInt(matcherMoves.group(1))));
                            }
                        }
                    }

                }
            }
        }
    }
}
