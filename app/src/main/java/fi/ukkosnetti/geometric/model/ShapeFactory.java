package fi.ukkosnetti.geometric.model;

public class ShapeFactory {

    public static Shape generate(Geom.Shape geomShape , double ... args) {
        if (geomShape.argumentAmount != args.length) {
            throw new IllegalArgumentException("Amount of arguments " + args.length + " does not match the required amount by given Shape " + geomShape);
        }
        Shape shape = null;
        switch (geomShape) {
            case CIRCLE:
                shape = new Circle(args[0]);
                break;
            case RECTANGLE:
                shape = new Rectangle(args[0], args[1]);
                break;
            case TRIANGLE:
                shape = new Triangle(args[0], args[1]);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported shape " + geomShape);
        }
        return shape;
    }
}
