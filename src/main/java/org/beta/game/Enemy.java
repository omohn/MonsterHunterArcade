package org.beta.game;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy implements GameObject{

    private int velocity;

    private Rectangle avatar;
    private Paint color;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean moveRight;
    private boolean moveDown;
    private Direction direction;

    public Enemy(Paint color, int x, int y, int width, int height, int velocity, Direction direction) {
        this.avatar = new Rectangle(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
        this.direction = direction;
        this.avatar.setFill(Paint.valueOf("red"));



    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public boolean isMoveDown() {
        return moveDown;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
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
        this.x += x;
        avatar.setX(this.x);

    }

    @Override
    public void setY(int y) {
        this.y += y;
        avatar.setY(this.y);

    }

    @Override
    public Shape getGameObject() {
        return avatar;
    }
}
