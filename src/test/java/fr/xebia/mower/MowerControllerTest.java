package fr.xebia.mower;

import org.junit.Test;

import static fr.xebia.mower.Orientation.EAST;
import static fr.xebia.mower.Orientation.NORTH;
import static fr.xebia.mower.Position.createPosition;
import static fr.xebia.mower.RectangularGround.createRectangularGround;
import static org.fest.assertions.Assertions.assertThat;

public class MowerControllerTest {

    @Test
    public void should_add_mower() {
        // Given
        MowerController mowerController = new MowerController(createRectangularGround(5, 5));

        // When
        mowerController.addMower(new Mower(Position.createDefaultPosition()));

        // Then
        assertThat(mowerController.getMowers()).hasSize(1);
    }

    @Test
    public void should_consume_instruction() {
        // Given
        MowerController mowerController = new MowerController(createRectangularGround(5, 5));
        mowerController.addMower(new Mower(createPosition(1, 2, NORTH)));
        mowerController.addMower(new Mower(createPosition(3, 3, EAST)));

        // When
        Position firstMowerFinalPosition = mowerController.consumeInstructions("GAGAGAGAA");
        Position secondMowerFinalPosition = mowerController.consumeInstructions("AADAADADDA");

        // Then
        assertThat(firstMowerFinalPosition.getX()).isEqualTo(1);
        assertThat(firstMowerFinalPosition.getY()).isEqualTo(3);
        assertThat(firstMowerFinalPosition.getOrientation()).isEqualTo(NORTH);

        assertThat(secondMowerFinalPosition.getX()).isEqualTo(5);
        assertThat(secondMowerFinalPosition.getY()).isEqualTo(1);
        assertThat(secondMowerFinalPosition.getOrientation()).isEqualTo(EAST);
    }
}
