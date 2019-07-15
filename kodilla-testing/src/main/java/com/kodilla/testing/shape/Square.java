package com.kodilla.testing.shape;

public class Square implements Shape {

    private final static String shapeName = "square" ;
    private final static String paramName = "side length" ;
    private double sideLength ;

    public Square (double sideLength) {
        this.sideLength = sideLength ;
    }

    // @Override
    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        // return sideLength^2 ;
        return Math.pow(sideLength,2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        return Double.compare(square.sideLength, sideLength) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(sideLength);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return shapeName + " " + sideLength;
    }

}