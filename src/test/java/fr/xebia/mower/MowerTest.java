package fr.xebia.mower;

import org.junit.Test;

import static fr.xebia.mower.Instruction.*;
import static fr.xebia.mower.Orientation.*;
import static fr.xebia.mower.Position.createPosition;
import static fr.xebia.mower.RectangularGround.createRectangularGround;
import static org.fest.assertions.Assertions.assertThat;

public class MowerTest {

    @Test
    public void should_get_position_of_current_mower() {
        // Given
        Mower mower = new Mower(createPosition(0, 0, WEST));
        mower.setGround(createRectangularGround(5, 5));

        // When
        Position position = mower.getPosition();

        // Then
        assertThat(position.getX()).isEqualTo(0);
        assertThat(position.getY()).isEqualTo(0);
        assertThat(position.getOrientation()).isEqualTo(WEST);
    }

    @Test
    public void should_mower_change_orientation_when_turn_left() {
        // Given
        Mower mower = new Mower(createPosition(1, 1, NORTH));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(LEFT);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(1);
        assertThat(mower.getPosition().getY()).isEqualTo(1);
        assertThat(mower.getPosition().getOrientation()).isEqualTo(WEST);
    }

    @Test
    public void should_mower_change_orientation_when_turn_right() {
        // Given
        Mower mower = new Mower(createPosition(1, 1, NORTH));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(RIGHT);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(1);
        assertThat(mower.getPosition().getY()).isEqualTo(1);
        assertThat(mower.getPosition().getOrientation()).isEqualTo(EAST);
    }

    @Test
    public void should_mower_change_x_position_when_west_oriented_and_advance() {
        // Given
        Mower mower = new Mower(createPosition(1, 1, WEST));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(ADVANCE);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(0);
        assertThat(mower.getPosition().getY()).isEqualTo(1);
        assertThat(mower.getPosition().getOrientation()).isEqualTo(WEST);
    }

    @Test
    public void should_mower_change_x_position_when_east_oriented_and_advance() {
        // Given
        Mower mower = new Mower(createPosition(1, 1, EAST));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(ADVANCE);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(2);
        assertThat(mower.getPosition().getY()).isEqualTo(1);
        assertThat(mower.getPosition().getOrientation()).isEqualTo(EAST);
    }

    @Test
    public void should_mower_change_y_position_when_south_oriented_and_advance() {
        // Given
        Mower mower = new Mower(createPosition(1, 1, SOUTH));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(ADVANCE);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(1);
        assertThat(mower.getPosition().getY()).isEqualTo(0);
        assertThat(mower.getPosition().getOrientation()).isEqualTo(SOUTH);
    }

    @Test
    public void should_mower_change_y_position_when_north_oriented_and_advance() {
        // Given
        Mower mower = new Mower(createPosition(1, 1, NORTH));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(ADVANCE);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(1);
        assertThat(mower.getPosition().getY()).isEqualTo(2);
        assertThat(mower.getPosition().getOrientation()).isEqualTo(NORTH);
    }

    @Test
    public void should_not_move_if_new_position_west_outbounds() {
        // Given
        Mower mower = new Mower(createPosition(0, 1, WEST));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(ADVANCE);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(0);
        assertThat(mower.getPosition().getY()).isEqualTo(1);
    }

    @Test
    public void should_not_move_if_new_position_north_outbounds() {
        // Given
        Mower mower = new Mower(createPosition(3, 5, NORTH));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(ADVANCE);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(3);
        assertThat(mower.getPosition().getY()).isEqualTo(5);
    }

    @Test
    public void should_not_move_if_new_position_east_outbounds() {
        // Given
        Mower mower = new Mower(createPosition(5, 2, EAST));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(ADVANCE);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(5);
        assertThat(mower.getPosition().getY()).isEqualTo(2);
    }

    @Test
    public void should_not_move_if_new_position_south_outbounds() {
        // Given
        Mower mower = new Mower(createPosition(3, 0, SOUTH));
        mower.setGround(createRectangularGround(5, 5));

        // When
        mower.consumeInstruction(ADVANCE);

        // Then
        assertThat(mower.getPosition().getX()).isEqualTo(3);
        assertThat(mower.getPosition().getY()).isEqualTo(0);
    }

}
