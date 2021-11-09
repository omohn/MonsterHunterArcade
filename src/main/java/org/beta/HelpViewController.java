package org.beta;

import java.io.IOException;
import javafx.fxml.FXML;

public class HelpViewController {

    @FXML
    private void switchToStartScreenView() throws IOException {
        App.setRoot("startScreenView");
    }
}