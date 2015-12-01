package fi.ukkosnetti.geometric.model;

public class Pyramid implements Shape3D {

    private final double length, width, height;


    public Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double volume() {
        return (length * width * height) / 3;
    }

    @Override
    public double perimeter() {
        return (length + width) * 2;
    }

    @Override
    public double area() {
        return (length * width) +
                ((perimeter() * height) / 2);
    }
}
