package fr.xebia.mower;

import org.junit.Test;

import static fr.xebia.mower.Instruction.*;
import static org.fest.assertions.Assertions.assertThat;

public class InstructionTest {

    @Test
    public void should_get_instruction_by_code() {
        // Given / When / Then
        assertThat(getByCode('G')).isEqualTo(LEFT);
        assertThat(getByCode('D')).isEqualTo(RIGHT);
        assertThat(getByCode('A')).isEqualTo(ADVANCE);
    }


}