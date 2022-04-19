package org.beta.objects;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.beta.App;

import java.net.MalformedURLException;
import java.net.URL;

public class Player extends GameObject{

    private Image sprite;

    public Player() {
        this.figure = new Sprite("SpriteStub.bmp");
        size = 40.0f;
    }

//    private void loadSprite() {
//        URL spriteURL = App.class.getResource("images/SpriteStub.bmp");
//        this.sprite = new Image(spriteURL.toExternalForm(), 150, 150, true, true);
//    }

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

//    @Override
    public Image getSprite() {
        return this.sprite;
    }

    @Override
    public float getSize() {
        return size;
    }

//    @Override
//    public void render(GraphicsContext context) {
//        context.drawImage(getSprite(), 50, 0, 51, 51, getX(), getY(), getSize(), getSize());
//    }



}
