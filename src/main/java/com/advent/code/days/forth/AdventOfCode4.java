package com.advent.code.days.forth;

import java.util.List;
import java.util.Objects;

public class AdventOfCode4 {

    public long countPairsFullyContainsByOther(List<Pair> pairs) {
        return pairs.stream().filter(this::fullyContainsByOther).count();
    }

    public long countPairsFullyContainsOrEqualsByOther(List<Pair> pairs) {
        return pairs.stream().filter(this::overlapedByOther).count();
    }


    public Boolean fullyContainsByOther(Pair pair) {
        Assignment leftAssignment = pair.getLeftAssignment();
        Assignment rightAssignment = pair.getRightAssignment();
        Integer leftRangeSize = leftAssignment.endRange - leftAssignment.beginRange;
        Integer rightRangeSize = rightAssignment.endRange - rightAssignment.beginRange;
        if (leftRangeSize > rightRangeSize) {
            if (rightAssignment.beginRange >= leftAssignment.beginRange && rightAssignment.endRange <= leftAssignment.getEndRange()) {
                return true;
            }
        }
        if (rightRangeSize > leftRangeSize) {
            if (leftAssignment.beginRange >= rightAssignment.beginRange && leftAssignment.endRange <= rightAssignment.getEndRange()) {
                return true;
            }
        }
        if (Objects.equals(rightRangeSize, leftRangeSize)) {
            if (leftAssignment.getBeginRange().equals(rightAssignment.getBeginRange())) {
                return true;
            }
        }
        return false;
    }

    public Boolean overlapedByOther(Pair pair) {
        Assignment leftAssignment = pair.getLeftAssignment();
        Assignment rightAssignment = pair.getRightAssignment();
        if (leftAssignment.beginRange > rightAssignment.beginRange) {
            if (leftAssignment.beginRange <= rightAssignment.endRange) {
                return true;
            }
        }
        if (leftAssignment.beginRange < rightAssignment.beginRange) {
            if (rightAssignment.beginRange <= leftAssignment.endRange) {
                return true;
            }

        }
        if (leftAssignment.beginRange == rightAssignment.beginRange || rightAssignment.endRange.equals(leftAssignment.endRange)) {
            return true;
        }
        return false;
    }

}
