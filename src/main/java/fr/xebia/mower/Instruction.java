package fr.xebia.mower;

import java.util.Objects;

public enum Instruction {
    LEFT('G'), RIGHT('D'), ADVANCE('A');

    private final Character code;

    Instruction(Character code) {
        this.code = code;
    }

    public static Instruction getByCode(Character code) {
        for (Instruction instruction : Instruction.values()) {
            if (Objects.equals(instruction.code, code)) {
                return instruction;
            }
        }

        throw new IllegalArgumentException("No instruction with code " + code);
    }
}
