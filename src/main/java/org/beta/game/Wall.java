package org.beta.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Wall extends GameObject{

    private static final int WALL_DEPTH = 4; // Thickness of a wall
    private static final int WALL_WIDTH = 64; // Length of a wall
    private static final Color WALL_COLOR = Color.BLUE; // Length of a wall

    private boolean isHorizontal;
    private int x; // top-left x-Position
    private int y; // top-left y-Position

    private Rectangle wall;

    public Wall(int x, int y, boolean isHorizontal) {
        this.isHorizontal = isHorizontal;
        this.x = x;
        this.y = y;

        if (isHorizontal) {
            this.wall = new Rectangle(WALL_WIDTH, WALL_DEPTH);
        } else {
            this.wall = new Rectangle(WALL_DEPTH, WALL_WIDTH);
        }

        setX(x);
        setY(y);


        this.wall.setFill(WALL_COLOR);


    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.wall.setX(this.x);
    }

    @Override
    public void setY(int y) {
        this.wall.setY(this.y);
    }

    @Override
    public Shape getGameObject() {
        return wall;
    }

    @Override
    public ImageView getSprite() {
        return null;
    }
}
