package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public ShapeCollector() {
        this.shapes = shapes;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public void showFigures() {
        System.out.println(shapes.toString());
    }

    public int getSize() {
        return shapes.size();
    }

    @Override
    public String toString() {
        return shapes.toString();
    }

    public static void main(String[] args) {

        ShapeCollector shapes = new ShapeCollector();
        Shape myCircle = new Circle(11);
        Shape mySquare = new Square(21);
        Shape myTriangle = new Triangle(31);
        shapes.addFigure(myCircle);
        shapes.addFigure(mySquare);
        shapes.addFigure(myTriangle);

        shapes.showFigures();

    }
}