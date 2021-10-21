package org.beta;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.beta.game.GameObject;
import org.beta.game.PlayField;
import org.beta.game.Wall;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayFieldViewController {

    public static final int OFFSET = 2;
    Random random = new Random();

    final int TILE_SIZE = 64;
    final int WALL_THICK = 4;

    private PlayField playField;

    private List<Wall> walls = new ArrayList<>();

    private int[][] map = {
            {0, 18, 10, 6, 18, 10, 2, 10, 6, 18, 10, 6, 0},
            {0, 20, 18, 0, 8, 10, 0, 10, 8, 0, 6, 20, 0},
            {10, 0, 4, 16, 10, 6, 20, 18, 10, 4, 16, 0, 10},
            {0, 16, 12, 20, 18, 8, 0, 8, 6, 20, 24, 4, 0},
            {0, 20, 18, 8, 0, 6, 20, 18, 0, 8, 6, 20, 0},
            {0, 16, 8, 10, 12, 24, 8, 12, 24, 10, 8, 4, 0},
            {0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 0}
    };


    @FXML
    private void switchToStartScreenView() throws IOException {
        App.setRoot("startScreenView");
    }

    @FXML
    private Pane labyrinth;

    @FXML
    public void initialize() {

        playField = new PlayField();

        List<Wall> wallsList = playField.getEnvironment();

        for (Wall wall:
             wallsList) {

            labyrinth.getChildren().add(wall.getWall());
        }




//        Rectangle[][] rectangles = new Rectangle[13][7];

//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 7; j++) {
//
//                rectangles[i][j] = new Rectangle(TILE_SIZE * i + 2, TILE_SIZE * j + 2, TILE_SIZE, TILE_SIZE);
//                rectangles[i][j].setFill(getRandomColor());
//                labyrinth.getChildren().add(rectangles[i][j]);
//            }
//
//        }
//
//        System.out.println("map.length = " + map.length);
//        System.out.println("map[].length = " + map[0].length);
//
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                Rectangle top2 = new Rectangle(TILE_SIZE, WALL_THICK);
//                top2.setFill(Color.BLUE);
//                top2.setX(OFFSET + j * TILE_SIZE);
//                top2.setY(OFFSET + i * TILE_SIZE);
//                labyrinth.getChildren().add(top2);
//
//                Rectangle right2 = new Rectangle(WALL_THICK, TILE_SIZE);
//                right2.setFill(Color.BLUE);
//                right2.setX((j + 1) * TILE_SIZE - WALL_THICK + OFFSET);
//                right2.setY(OFFSET + i * TILE_SIZE);
//                labyrinth.getChildren().add(right2);
//
//                Rectangle bottom2 = new Rectangle(TILE_SIZE, WALL_THICK);
//                bottom2.setFill(Color.BLUE);
//                bottom2.setX(j * TILE_SIZE + OFFSET);
//                bottom2.setY((i + 1) * TILE_SIZE - WALL_THICK + OFFSET);
//                labyrinth.getChildren().add(bottom2);
//
//                Rectangle left2 = new Rectangle(WALL_THICK, TILE_SIZE);
//                left2.setFill(Color.BLUE);
//                left2.setX(j * TILE_SIZE + OFFSET);
//                left2.setY(i * TILE_SIZE + OFFSET);
//                labyrinth.getChildren().add(left2);
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.print("\n");
//        }

//        Rectangle top = new Rectangle(TILE_SIZE, WALL_THICK);
//        top.setFill(Color.BLUE);
//        top.setX(OFFSET);
//        top.setY(OFFSET);
//        labyrinth.getChildren().add(top);
//
//        Rectangle right = new Rectangle(WALL_THICK, TILE_SIZE);
//        right.setFill(Color.BLUE);
//        right.setX(TILE_SIZE - WALL_THICK + OFFSET);
//        right.setY(OFFSET);
//        labyrinth.getChildren().add(right);
//
//        Rectangle bottom = new Rectangle(TILE_SIZE, WALL_THICK);
//        bottom.setFill(Color.BLUE);
//        bottom.setX(OFFSET);
//        bottom.setY(TILE_SIZE - WALL_THICK + OFFSET);
//        labyrinth.getChildren().add(bottom);
//
//        Rectangle left = new Rectangle(WALL_THICK, TILE_SIZE);
//        left.setFill(Color.BLUE);
//        left.setX(OFFSET);
//        left.setY(OFFSET);
//        labyrinth.getChildren().add(left);



//        labyrinth.getChildren().add(new Rectangle(13 * TILE_SIZE, 7 * TILE_SIZE, TILE_SIZE, WALL_THICK));


    }

    private Color getRandomColor() {
        double r = random.nextDouble();
        double g = random.nextDouble();
        double b = random.nextDouble();

        return new Color(r, g, b, 1);

    }


}
