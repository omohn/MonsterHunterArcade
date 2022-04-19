package org.beta.objects;

import javafx.geometry.Point2D;

public class Door extends GameObject{

    @Override
    public double getX() {
        return location.getX();
    }

    @Override
    public double getY() {
        return 0.0;
    }

    @Override
    public void setLocation(double x, double y) {

    }

    @Override
    public Point2D getLocation() {
        return null;
    }

    @Override
    public float getSize() {
        return 0;
    }
}
