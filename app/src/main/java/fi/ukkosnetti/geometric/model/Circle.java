package fi.ukkosnetti.geometric.model;

public class Circle implements Shape {

    public final double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public double perimeter() {
        return diameter / 2;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(diameter / 2, 2);
    }
}
