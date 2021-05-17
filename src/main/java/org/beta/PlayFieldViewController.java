package org.beta;

import javafx.fxml.FXML;

import java.io.IOException;

public class PlayFieldViewController {

    @FXML
    private void switchToStartScreenView() throws IOException {
        App.setRoot("startScreenView");
    }
}
