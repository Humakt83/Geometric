package fi.ukkosnetti.geometric.model;

public class Triangle implements Shape {

    public final double height, width;

    public Triangle(double height, double width) {
        this.height = height;
        this.width = width;
    }


    @Override
    public double perimeter() {
        return height + width;
    }

    @Override
    public double area() {
        return (height * width) / 2;
    }
}
