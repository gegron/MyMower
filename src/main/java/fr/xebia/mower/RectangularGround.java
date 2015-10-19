package fr.xebia.mower;

public class RectangularGround {
    private Integer xMin;
    private Integer yMin;
    private Integer xMax;
    private Integer yMax;

    private RectangularGround(Integer xMax, Integer yMax) {
        this.xMin = this.yMin = 0;

        this.xMax = xMax;
        this.yMax = yMax;
    }

    public static RectangularGround createRectangularGround(Integer xMax, Integer yMax) {
        return new RectangularGround(xMax, yMax);
    }

    public boolean authorizePosition(Position nextPosition) {
        return nextPosition.getX() >= xMin &&
                nextPosition.getX() <= xMax &&
                nextPosition.getY() >= yMin &&
                nextPosition.getY() <= yMax;

    }
}
