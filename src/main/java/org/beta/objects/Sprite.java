package org.beta.objects;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.beta.App;

import java.net.URL;

public class Sprite implements Renderable {

    private final double SPRITE_SIZE = 64;

    Image image;
    URL imageURL;

    public Sprite(String fileName) {
        String path = "images/" + fileName;
        this.imageURL = App.class.getResource(path);
        this.image = new Image(imageURL.toExternalForm(), 150, 150, true, true);
    }

    @Override
    public void render(GraphicsContext gc, Renderable figure, Point2D location) {
        gc.drawImage(image, 50, 0, 51, 51, location.getX(),
                location.getY(), SPRITE_SIZE, SPRITE_SIZE);
    }
}
