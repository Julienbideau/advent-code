package com.advent.code.days.fifth;

public class Pair {

    Assignment leftAssignment;
    Assignment rightAssignemnt;

    public Pair(Assignment leftAssignment, Assignment rightAssignemnt) {
        this.leftAssignment = leftAssignment;
        this.rightAssignemnt = rightAssignemnt;
    }

    public Assignment getLeftAssignment() {
        return leftAssignment;
    }

    public Assignment getRightAssignment() {
        return rightAssignemnt;
    }
}
