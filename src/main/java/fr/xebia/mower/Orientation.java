package fr.xebia.mower;

public enum Orientation {
    WEST(0),
    NORTH(90),
    EAST(180),
    SOUTH(270);

    // TODO: encapsulate in Degree class
    private Integer degree;

    Orientation(Integer degree) {
        this.degree = degree;
    }

    public Orientation turnLeft() {
        Integer newDegree = degree - 90;

        if (newDegree < 0) {
            newDegree += 360;
        }

        return findOrientationByDegree(newDegree);
    }

    public Orientation turnRight() {
        Integer newDegree = degree + 90;

        if (newDegree >= 360) {
            newDegree = newDegree % 360;
        }

        return findOrientationByDegree(newDegree);
    }

    private Orientation findOrientationByDegree(Integer degree) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.degree.equals(degree)) {
                return orientation;
            }
        }

        throw new IllegalArgumentException("No orientation with degree " + degree);
    }
}
