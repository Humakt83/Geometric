package fi.ukkosnetti.geometric.model;

/**
 * Created by Thunder on 26.7.2015.
 */
public class Geom {

    public enum Shape {
        SQUARE, TRIANGLE, CIRCLE;
    }

    public final int picture;

    public final Shape shape;

    public Geom(int picture, Shape shape) {
        this.picture = picture;
        this.shape = shape;
    }

}
