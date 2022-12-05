package com.advent.code.days.forth;

public class Assignment {

    Integer beginRange;

    Integer endRange;

    public Assignment(Integer beginRange, Integer endRange) {
        this.beginRange = beginRange;
        this.endRange = endRange;
    }

    public Integer getBeginRange() {
        return beginRange;
    }

    public Integer getEndRange() {
        return endRange;
    }
}
