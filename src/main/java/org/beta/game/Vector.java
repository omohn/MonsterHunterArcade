package org.beta.game;

public class Vector {

    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setCoords(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void addCoords(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public void addCoords(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}
