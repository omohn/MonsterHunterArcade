package org.beta.objects;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {

    float size;
    Point2D location;
    Direction direction;
    double velocity;
    Rectangle boundary;
    Renderable figure;

    public double getX() {
        return location.getX();
    };

    public double getY() {
        return location.getY();
    };

    public void setLocation(double x, double y) {
        location = new Point2D(x, y);
    };

//    public abstract Image getSprite();

    public Point2D getLocation() {
        return location;
    };

    public abstract float getSize();

    public void doRender(GraphicsContext context) {
        figure.render(context, figure, location);
    }

}


