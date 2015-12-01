package fi.ukkosnetti.geometric.model;

public class RectangularParallelepiped implements Shape3D {

    private final double width, height, length;

    public RectangularParallelepiped(double width, double height, double length) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public double volume() {
        return length * height * width;
    }

    @Override
    public double perimeter() {
        return (length + height + width) * 4;
    }

    @Override
    public double area() {
        return (length * height * 2) + (length * width * 2) + (width * height * 2);
    }
}
