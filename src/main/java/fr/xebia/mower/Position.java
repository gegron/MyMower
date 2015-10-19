package fr.xebia.mower;

import static fr.xebia.mower.Orientation.NORTH;

public class Position {
    private Integer x;
    private Integer y;
    private Orientation orientation;

    private Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public static Position createDefaultPosition() {
        return new Position(0, 0, NORTH);
    }

    public static Position createPosition(int x, int y, Orientation orientation) {
        return new Position(x, y, orientation);
    }

    public Position createNextPosition(Instruction instruction) {
        switch (instruction) {
            case LEFT:
                return createPosition(x, y, orientation.turnLeft());
            case RIGHT:
                return createPosition(x, y, orientation.turnRight());
            case ADVANCE:
                switch (orientation) {
                    case EAST:
                        return createPosition(x + 1, y, orientation);
                    case WEST:
                        return createPosition(x - 1, y, orientation);
                    case NORTH:
                        return createPosition(x, y + 1, orientation);
                    case SOUTH:
                        return createPosition(x, y - 1, orientation);
                }
        }

        throw new IllegalArgumentException("Instruction " + instruction + " cannot be consumed");
    }
}
