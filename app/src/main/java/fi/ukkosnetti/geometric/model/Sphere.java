package fi.ukkosnetti.geometric.model;

public class Sphere implements Shape3D {

    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
