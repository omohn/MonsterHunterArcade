package org.beta.game;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy extends Rectangle implements GameObject{

    private long velocity;
    private short direction;

    public Enemy(double x, double y, double width, double height, long velocity, short direction) {
        super(x, y, width, height);
        this.velocity = velocity;
        this.direction = direction;
        setFill(Paint.valueOf("red"));
    }

    @Override
    public Shape getGameObject() {
        return this;
    }
}
