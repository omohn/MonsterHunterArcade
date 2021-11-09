package org.beta;

import javafx.fxml.FXML;

import java.io.IOException;

public class HighScoreViewController {

    @FXML
    private void switchToStartScreenView() throws IOException {
        App.setRoot("startScreenView");
    }
}
