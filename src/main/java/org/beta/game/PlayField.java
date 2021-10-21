package org.beta.game;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayField extends Pane {

    private List<Wall> environment = new ArrayList<>();

    private final int FIELD_SIZE = 64;
    private final int WALL_DEPTH = 4;

    private int[][] map = {
            {0, 18, 10, 6, 18, 10, 2, 10, 6, 18, 10, 6, 0},
            {0, 20, 18, 0, 8, 10, 0, 10, 8, 0, 6, 20, 0},
            {10, 0, 4, 16, 10, 6, 20, 18, 10, 4, 16, 0, 10},
            {0, 16, 12, 20, 18, 8, 0, 8, 6, 20, 24, 4, 0},
            {0, 20, 18, 8, 0, 6, 20, 18, 0, 8, 6, 20, 0},
            {0, 16, 8, 10, 12, 24, 8, 12, 24, 10, 8, 4, 0},
            {0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 0}
    };

    private int playFieldRows = map.length;
    private int playFieldCols = map[0].length;

    public PlayField() {


        for (int i = 0; i < playFieldRows; i++) {
            for (int j = 0; j < playFieldCols; j++) {
                int cell = map[i][j];
                if (cell - 16 >= 0) {
                    environment.add(new Wall(j * FIELD_SIZE, i * FIELD_SIZE, false));
                    cell -= 16;
                }
                if (cell - 8 >= 0) {
                    environment.add(new Wall(j * FIELD_SIZE, i * FIELD_SIZE + FIELD_SIZE - WALL_DEPTH, true));
                    cell -= 8;
                }
                if (cell - 4 >= 0) {
                    environment.add(new Wall(j * FIELD_SIZE + FIELD_SIZE - WALL_DEPTH, i * FIELD_SIZE, false));
                    cell -= 4;
                }
                if (cell - 2 >= 0) {
                    environment.add(new Wall(j * FIELD_SIZE, i * FIELD_SIZE, true));
                    cell -= 2;
                }
                if (cell != 0) {
                    System.out.println("Something's wrong with your Array");
                }


            }

        }
    }

    public List<Wall> getEnvironment() {
        return environment;
    }
}
