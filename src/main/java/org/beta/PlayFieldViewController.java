package org.beta;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PlayFieldViewController {

    @FXML
    private void switchToStartScreenView() throws IOException {
        App.setRoot("startScreenView");
    }

    @FXML
    private Pane labyrinth;



}
