package org.beta.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Player extends GameObject {

    private Circle avatar;
    private Paint color;
    private int x;
    private int y;
    private int size;
    private int radius;
    private short direction;
    private int velocity;


    public Player(Paint color, int x, int y, int size) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
        this.radius = size / 2;
        this.avatar = new Circle(x + radius, y +  radius, radius);
        avatar.setFill(color);
//        String file = "../images/blue_wizard.jpeg";
//
//        try {
//            this.sprite = new Image(new FileInputStream(file));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        avatar.setCenterX(avatar.getCenterX() + x);
    }

    @Override
    public void setY(int y) {
        avatar.setCenterY(avatar.getCenterY() + y);
    }

    public void setDirection(short direction) {
        this.direction = direction;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public Shape getGameObject() {
        return avatar;
    }

    @Override
    public ImageView getSprite() {
        return new ImageView(sprite);
    }
}
