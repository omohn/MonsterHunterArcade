package org.beta;

import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.beta.controls.KeyHandler;
import org.beta.game.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayFieldViewController {

    public static final int OFFSET = 2;
    Random random = new Random();

    KeyHandler keyInput = KeyHandler.getInstance();

    final int TILE_SIZE = 64;
    final int WALL_THICK = 4;

    private final int FIELD_SIZE = 64;
    private final int WALL_DEPTH = 4;
    private final int SPRITE_SIZE = FIELD_SIZE - 2 * WALL_DEPTH;

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

        Ball myPlayer = new Ball(0, 0, 30, Color.GREEN, 1, 1);


        labyrinth.getChildren().add(myPlayer);

        final LongProperty lastUpdateTime = new SimpleLongProperty(0);
        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (lastUpdateTime.get() > 0) {
//                    System.out.println("timer started");


                    // change the myPlayer position
                    double elapsedSeconds = (now - lastUpdateTime.get()) / 1_000_000_000.;
//                    myPlayer.setCenterX(myPlayer.getCenterX() + elapsedSeconds * myPlayer.velocity * Math.cos(myPlayer.angle));
//                    myPlayer.setCenterY(myPlayer.getCenterY() + 1);

//                    // bounce against a vertical wall
//                    if (myPlayer.getCenterX() <= myPlayer.getRadius()
//                            || myPlayer.getCenterX() >= (myPlayerContainer.getWidth() - myPlayer.getRadius())) {
//                        myPlayer.angle = Math.PI - myPlayer.angle;
//                    }
//                    // bounce against a horizontal wall
//                    if (myPlayer.getCenterY() <= myPlayer.getRadius()
//                            || myPlayer.getCenterY() >= (myPlayerContainer.getHeight() - myPlayer.getRadius())) {
//                        {
//                            myPlayer.angle = 2 * Math.PI - myPlayer.angle;
//                        }
                    if (keyInput.isDown(KeyCode.UP)) {
                        myPlayer.setCenterY(myPlayer.getCenterY() - 1);
                    }
                    if (keyInput.isDown(KeyCode.DOWN)) {
                        myPlayer.setCenterY(myPlayer.getCenterY() + 1);
                    }
                    if (keyInput.isDown(KeyCode.RIGHT)) {
                        myPlayer.setCenterX(myPlayer.getCenterX() + 1);
                    }
                    if (keyInput.isDown(KeyCode.LEFT)) {
                        myPlayer.setCenterX(myPlayer.getCenterX() - 1);
                    }
                }


                lastUpdateTime.set(now);

            }
        };

        timer.start();







    }

    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("key pressed");
    }

    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("key released");
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
