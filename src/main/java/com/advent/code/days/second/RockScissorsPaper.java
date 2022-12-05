package com.advent.code.days.second;

public enum RockScissorsPaper {

    ROCK(1),
    SCISSORS(3),
    PAPER(2),
    ;

    public final Integer value;

    RockScissorsPaper(Integer value) {
        this.value = value;
    }
}
