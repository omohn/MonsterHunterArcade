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
            {0, 9, 5, 3, 9, 5, 1, 5, 3, 9, 5, 3, 0},
            {0, 10, 9, 0, 4, 5, 0, 5, 4, 0, 3, 10, 0},
            {5, 0, 2, 8, 5, 3, 10, 9, 5, 2, 8, 0, 5},
            {0, 8, 6, 10, 9, 4, 0, 4, 3, 10, 12, 2, 0},
            {0, 10, 9, 4, 0, 3, 10, 9, 0, 4, 3, 10, 0},
            {0, 8, 4, 5, 6, 12, 4, 6, 12, 5, 4, 2, 0},
            {0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0}
    };

    private int playFieldRows = map.length;
    private int playFieldCols = map[0].length;

    public PlayField() {


        for (int i = 0; i < playFieldRows; i++) {
            for (int j = 0; j < playFieldCols; j++) {
                int cell = map[i][j];
                if (cell - 8 >= 0) {
                    environment.add(new Wall(j * FIELD_SIZE, i * FIELD_SIZE, false));
                    cell -= 8;
                }
                if (cell - 4 >= 0) {
                    environment.add(new Wall(j * FIELD_SIZE, i * FIELD_SIZE + FIELD_SIZE - WALL_DEPTH, true));
                    cell -= 4;
                }
                if (cell - 2 >= 0) {
                    environment.add(new Wall(j * FIELD_SIZE + FIELD_SIZE - WALL_DEPTH, i * FIELD_SIZE, false));
                    cell -= 2;
                }
                if (cell - 1 >= 0) {
                    environment.add(new Wall(j * FIELD_SIZE, i * FIELD_SIZE, true));
                    cell -= 1;
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
