package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private final static String shapeName = "triangle" ;
    private final static String paramName = "side length" ;
    private double sideLength ;

    public Triangle (double sideLength) {
        this.sideLength = sideLength ;
    }

    // @Override
    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        // return sideLength^2 * 3^(0.5)/4;
        return Math.pow(sideLength,2) * Math.sqrt(3)/4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        return Double.compare(triangle.sideLength, sideLength) == 0;
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
