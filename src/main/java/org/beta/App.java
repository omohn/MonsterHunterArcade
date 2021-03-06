package org.beta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.beta.controls.KeyHandler;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        Group group = new Group();
        scene = new Scene(loadFXML("startScreenView"), 850, 600);
        KeyHandler.getInstance().observeScene(scene);


//        Font.loadFont(getClass().getResourceAsStream("fonts/Pixelfy-ow9yd.ttf"), 14);
        stage.setScene(scene);
        stage.setTitle("Monster Hunter Arcade");
        stage.show();


    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}

