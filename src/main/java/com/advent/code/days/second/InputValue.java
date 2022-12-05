package com.advent.code.days.second;

public class InputValue {

    RockScissorsPaper opponentChoice;
    RockScissorsPaper ourChoice;

    public InputValue(RockScissorsPaper opponentChoice, RockScissorsPaper ourChoice) {
        this.opponentChoice = opponentChoice;
        this.ourChoice = ourChoice;
    }

    public RockScissorsPaper getOpponentChoice() {
        return opponentChoice;
    }

    public RockScissorsPaper getOurChoice() {
        return ourChoice;
    }
}
