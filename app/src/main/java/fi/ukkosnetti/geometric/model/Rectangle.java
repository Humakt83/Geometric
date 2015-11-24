package fi.ukkosnetti.geometric.model;

public class Rectangle implements Shape {

    public final double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public double perimeter() {
        return (width + height) * 2;
    }

    @Override
    public double area() {
        return width * height;
    }
}
