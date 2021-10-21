package org.beta.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall implements GameObject{

    private static final int WALL_DEPTH = 4; // Thickness of a wall
    private static final int WALL_WIDTH = 64; // Length of a wall
    private static final Color WALL_COLOR = Color.BLUE; // Length of a wall

    private boolean isHorizontal = false;
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

        this.wall.setX(this.x);
        this.wall.setY(this.y);
        this.wall.setFill(WALL_COLOR);


    }

    public Rectangle getWall() {
        return wall;
    }
}
