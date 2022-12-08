package com.advent.code.days.fifth;

import java.util.List;

public class InputValue {

    String[][] stacks;
    List<Instruction> instructions;


    public InputValue(String[][] stacks, List<Instruction> instructions) {
        this.stacks = stacks;
        this.instructions = instructions;
    }

    public String[][] getStacks() {
        return stacks;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}
