package fr.xebia.mower;

public class Mower {
    private Position position;
    private RectangularGround ground;

    public Mower(Position initialPosition) {
        this.position = initialPosition;
    }

    public Position getPosition() {
        return position;
    }

    public void consumeInstruction(Instruction instruction) {
        Position nextPosition = position.createNextPosition(instruction);

        if (ground != null && ground.authorizePosition(nextPosition)) {
            this.position = nextPosition;
        }
    }

    public void setGround(RectangularGround ground) {
        this.ground = ground;
    }
}
