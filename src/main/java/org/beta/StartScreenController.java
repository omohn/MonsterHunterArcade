package org.beta;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StartScreenController {

    @FXML
    private void switchToPlayFieldView() throws IOException {
        App.setRoot("playFieldView");
    }

    @FXML
    private void switchToHelpView() throws IOException {
        App.setRoot("helpView");
    }

    @FXML
    private void switchToHighScoreView() throws IOException {
        App.setRoot("highScoreView");
    }

}