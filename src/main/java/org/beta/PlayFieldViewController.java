package org.beta;

import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.beta.controls.KeyHandler;
import org.beta.game.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayFieldViewController {

    public static final int OFFSET = 2;

    KeyHandler keyInput = KeyHandler.getInstance();

    final int TILE_SIZE = 64;
    final int WALL_THICK = 4;

    private final int FIELD_SIZE = 64;
    private final int WALL_DEPTH = 4;
    private final int SPRITE_SIZE = FIELD_SIZE - 2 * WALL_DEPTH;

    private PlayField playField;

    private List<GameObject> gameObjects = new ArrayList<>();

    @FXML
    private void switchToStartScreenView() throws IOException {
        App.setRoot("startScreenView");
    }

    @FXML
    private Pane labyrinth;

    @FXML
    public void initialize() {

        playField = new PlayField();



        List<GameObject> walls = playField.getEnvironment();

        for (GameObject wall:
             walls) {

            labyrinth.getChildren().add(wall.getGameObject());
        }

        Enemy first_enemy = new Enemy(Color.RED,3 * FIELD_SIZE + WALL_DEPTH, 0 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE, SPRITE_SIZE, 2, Direction.DOWN);
        Enemy sec_enemy = new Enemy(Color.RED, 10 * FIELD_SIZE + WALL_DEPTH, 1 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE, SPRITE_SIZE, 4, Direction.LEFT);
        Enemy third_enemy = new Enemy(Color.RED, 5 * FIELD_SIZE + WALL_DEPTH, 4 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE, SPRITE_SIZE, 3, Direction.LEFT);
        gameObjects.add(first_enemy);
        gameObjects.add(sec_enemy);
        gameObjects.add(third_enemy);


        Player yellow = new Player(Color.YELLOW, 1 * FIELD_SIZE + WALL_DEPTH, 6 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE);
        Player yellow2 = new Player(Color.YELLOW, 0 * FIELD_SIZE + WALL_DEPTH, 6 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE);
        Player yellow3 = new Player(Color.YELLOW, 0 * FIELD_SIZE + WALL_DEPTH, 5 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE);
        gameObjects.add(yellow);
        gameObjects.add(yellow2);
        gameObjects.add(yellow3);

        Player blue = new Player(Color.BLUE, 11 * FIELD_SIZE + WALL_DEPTH, 6 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE);
        Player blue2 = new Player(Color.BLUE, 12 * FIELD_SIZE + WALL_DEPTH, 6 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE);
        Player blue3 = new Player(Color.BLUE, 12 * FIELD_SIZE + WALL_DEPTH, 5 * FIELD_SIZE + WALL_DEPTH, SPRITE_SIZE);

        gameObjects.add(blue);
        gameObjects.add(blue2);
        gameObjects.add(blue3);

        for (GameObject gameObject :
                gameObjects) {
            labyrinth.getChildren().add(gameObject.getGameObject());
        }

        Player myPlayer = new Player(Color.RED, 0, 0, 64);
        myPlayer.getSprite().setX(100);
        myPlayer.getSprite().setY(100);
        myPlayer.getSprite().setFitHeight(50);
        myPlayer.getSprite().setFitWidth(50);
        labyrinth.getChildren().add(myPlayer.getSprite());


        // initiating a Game Loop
        final LongProperty lastUpdateTime = new SimpleLongProperty(0);
        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (lastUpdateTime.get() > 0) {

                    double elapsedSeconds = (now - lastUpdateTime.get()) / 1_000_000_000.;

                    moveEnemies(first_enemy, 0 * FIELD_SIZE + WALL_DEPTH, 4 * FIELD_SIZE + WALL_DEPTH);
                    moveEnemies(sec_enemy, 2 * FIELD_SIZE + WALL_DEPTH, 10 * FIELD_SIZE + WALL_DEPTH);
                    moveEnemies(third_enemy, 2 * FIELD_SIZE + WALL_DEPTH, 5 * FIELD_SIZE + WALL_DEPTH);

                    if (keyInput.isDown(KeyCode.UP)) {
                        blue.setY(-2);

                    }
                    if (keyInput.isDown(KeyCode.DOWN)) {
                        blue.setY(2);

                    }
                    if (keyInput.isDown(KeyCode.RIGHT)) {
                        blue.setX(2);

                    }
                    if (keyInput.isDown(KeyCode.LEFT)) {
                        blue.setX(-2);

                    }
                    if (keyInput.isDown(KeyCode.W)) {
                        yellow.setY(-2);

                    }
                    if (keyInput.isDown(KeyCode.S)) {
                        yellow.setY(2);

                    }
                    if (keyInput.isDown(KeyCode.D)) {
                        yellow.setX(2);

                    }
                    if (keyInput.isDown(KeyCode.A)) {
                        yellow.setX(-2);

                    }
                }


                lastUpdateTime.set(now);

            }
        };

        timer.start();

    }

    private void moveEnemies(Enemy enemy, int min, int max) {

        if (enemy.getDirection() == Direction.DOWN) {
            enemy.setY(enemy.getVelocity());
            if (enemy.getY() >= max) {
                enemy.setDirection(Direction.UP);
            }
        } else if (enemy.getDirection() == Direction.UP) {
            enemy.setY(-enemy.getVelocity());
            if (enemy.getY() <= min) {
                enemy.setDirection(Direction.DOWN);
            }
        } else if (enemy.getDirection() == Direction.RIGHT) {
            enemy.setX(enemy.getVelocity());
            if (enemy.getX() >= max) {
                enemy.setDirection(Direction.LEFT);
            }
        } else if (enemy.getDirection() == Direction.LEFT) {
            enemy.setX(-enemy.getVelocity());
            if (enemy.getX() <= min) {
                enemy.setDirection(Direction.RIGHT);
            }
        }

    }

}
