package org.beta.game;

import javafx.scene.shape.Shape;

public interface GameObject {

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    Shape getGameObject();
}
