package fi.ukkosnetti.geometric.model;

import java.io.Serializable;

public class Geom implements Serializable {

    public enum Shape {
        RECTANGLE(2), TRIANGLE(2), CIRCLE(1);

        public final int argumentAmount;

        private Shape(int argumentAmount) {
            this.argumentAmount = argumentAmount;
        }
    }

    public final int picture;

    public final Shape shape;

    public Geom(int picture, Shape shape) {
        this.picture = picture;
        this.shape = shape;
    }

}
