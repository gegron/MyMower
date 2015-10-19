package fr.xebia.mower;

import org.junit.Test;

import static fr.xebia.mower.Orientation.*;
import static org.fest.assertions.Assertions.assertThat;

public class OrientationTest {

    @Test
    public void should_turn_right() {
        // Given / When / Then
        assertThat(NORTH.turnLeft()).isEqualTo(WEST);
        assertThat(WEST.turnLeft()).isEqualTo(SOUTH);
        assertThat(SOUTH.turnLeft()).isEqualTo(EAST);
        assertThat(EAST.turnLeft()).isEqualTo(NORTH);
    }

    @Test
    public void should_turn_left() {
        // Given / When / Then
        assertThat(NORTH.turnRight()).isEqualTo(EAST);
        assertThat(EAST.turnRight()).isEqualTo(SOUTH);
        assertThat(SOUTH.turnRight()).isEqualTo(WEST);
        assertThat(WEST.turnRight()).isEqualTo(NORTH);
    }
}