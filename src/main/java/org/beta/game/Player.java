package org.beta.game;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Player implements GameObject {

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
}
