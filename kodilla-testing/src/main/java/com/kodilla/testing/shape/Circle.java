package com.kodilla.testing.shape;

public class Circle implements Shape {

    private final static String shapeName = "circle" ;
    private final static String paramName = "diameter" ;
    private double diameterLength ;

    public Circle(double diameterLength) {
        this.diameterLength = diameterLength;
    }

    // @Override
    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        // return Math.PI * (diameterLength/2)^2;
        return Math.PI * Math.pow(diameterLength/2,2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.diameterLength, diameterLength) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(diameterLength);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return shapeName + " " + diameterLength;
    }

}