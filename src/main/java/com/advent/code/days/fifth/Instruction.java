package com.advent.code.days.fifth;

public class Instruction {

    private Integer movesCount;
    private Integer from;
    private Integer to;

    public Integer getMovesCount() {
        return movesCount;
    }

    public void setMovesCount(Integer movesCount) {
        this.movesCount = movesCount;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "movesCount=" + movesCount +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
