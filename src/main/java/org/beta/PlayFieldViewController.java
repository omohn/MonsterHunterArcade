package org.beta;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
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

//    private int[][] map = {
//            {0, 18, 10, 6, 18, 10, 2, 10, 6, 18, 10, 6, 0},
//            {0, 20, 18, 0, 8, 10, 0, 10, 8, 0, 6, 20, 0},
//            {10, 0, 4, 16, 10, 6, 20, 18, 10, 4, 16, 0, 10},
//            {0, 16, 12, 20, 18, 8, 0, 8, 6, 20, 24, 4, 0},
//            {0, 20, 18, 8, 0, 6, 20, 18, 0, 8, 6, 20, 0},
//            {0, 16, 8, 10, 12, 24, 8, 12, 24, 10, 8, 4, 0},
//            {0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 0}
//    };


    @FXML
    private void switchToStartScreenView() throws IOException {
        App.setRoot("startScreenView");
    }

    @FXML
    private Pane labyrinth;

    @FXML
    public void initialize() {

        playField = new PlayField();

        List<GameObject> gameObjects = playField.getEnvironment();

        for (GameObject gameObject:
             gameObjects) {

            labyrinth.getChildren().add(gameObject.getGameObject());
        }

    }
//
//    private Color getRandomColor() {
//        double r = random.nextDouble();
//        double g = random.nextDouble();
//        double b = random.nextDouble();
//
//        return new Color(r, g, b, 1);
//
//    }


}
