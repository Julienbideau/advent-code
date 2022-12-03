package com.advent.code.common;

import java.util.Scanner;

@FunctionalInterface
public interface AdventOfCodeParser<T> {

    T parse(Scanner scanner);
}