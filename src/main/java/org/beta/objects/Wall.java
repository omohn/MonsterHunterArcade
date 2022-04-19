package org.beta.objects;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends GameObject{

    Color color = Color.BLUE;
    private final double WALL_WIDTH = 64.0;
    private final double WALL_HEIGHT = 4.0;
    private Orientation orientation;

    public Wall(Orientation orientation) {
        this.orientation = orientation;
        this.figure = (orientation == Orientation.HORIZONTAL ? new GameRectangle(WALL_WIDTH, WALL_HEIGHT, color) : new GameRectangle(WALL_HEIGHT, WALL_WIDTH, color));
//        this.figure = new GameRectangle(WALL_WIDTH, WALL_HEIGHT, color);
        this.boundary = new Rectangle(WALL_WIDTH, WALL_HEIGHT);
    }
    @Override
    public double getX() {
        return location.getX();
    }

    @Override
    public double getY() {
        return location.getY();
    }

    @Override
    public void setLocation(double x, double y) {
        this.location = new Point2D(x, y);
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public float getSize() {
        return size;
    }

    public void doRender(GraphicsContext context) {
        figure.render(context, figure, getLocation());

    }
}
