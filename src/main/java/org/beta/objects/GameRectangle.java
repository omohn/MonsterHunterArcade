package org.beta.objects;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class GameRectangle extends Rectangle implements Renderable {

    public GameRectangle(double width, double height, Paint fill) {
        super(width, height, fill);
    }

    @Override
    public void render(GraphicsContext context, Renderable figure, Point2D location) {
        context.setFill(getFill());
        context.fillRect(location.getX(), location.getY(), getWidth(), getHeight());
//        context.setFill(getFill());
//        context.fillRect(100,100, 200, 250);
    }
}
