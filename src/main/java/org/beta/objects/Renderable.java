package org.beta.objects;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public interface Renderable {

    void render(GraphicsContext context, Renderable figure, Point2D location);

}
