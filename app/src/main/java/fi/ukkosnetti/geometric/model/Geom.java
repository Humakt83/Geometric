package fi.ukkosnetti.geometric.model;

import java.io.Serializable;

public class Geom implements Serializable {

    public enum Shape {
        RECTANGLE(2, "Provide height and width"), TRIANGLE(2, "Provide height and width"), CIRCLE(1, "Provide diameter"),
        BALL(1, "Provide radius"), BOX(3, "Provide height, width and length"), PYRAMID(3, "Provide base length, width and pyramid height");

        public final int argumentAmount;

        public final String message;

        private Shape(int argumentAmount, String message) {

            this.argumentAmount = argumentAmount;
            this.message = message;
        }
    }

    public final int picture;

    public final Shape shape;

    public Geom(int picture, Shape shape) {
        this.picture = picture;
        this.shape = shape;
    }

}
