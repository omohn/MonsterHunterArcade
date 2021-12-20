package org.beta.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public abstract class GameObject {

    Image sprite;
    Vector location;
    Vector velocity;
    Rectangle boundary;


    abstract int getX();

    abstract int getY();

    abstract void setX(int x);

    abstract void setY(int y);

    public abstract Shape getGameObject();

    public abstract ImageView getSprite();
}
