package org.beta.game;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

    public double velocity;
    public double direction;

    public Ball(double centerX, double centerY, double radius, Paint fill, double velocity, double direction) {
        super(centerX, centerY, radius, fill);
        this.velocity = velocity;
        this.direction = direction;
    }
}
