package org.beta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.beta.controls.KeyHandler;
import org.beta.objects.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        // loading fonts - each font will be available via CSS -fx-font-family: fontname;
        // source: https://stackoverflow.com/questions/12173288/specifying-external-font-in-javafx-css

        Font.loadFont(getClass().getResource("fonts/PressStart2P-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/showg.ttf").toExternalForm(), 10);

        scene = new Scene(loadFXML("gameView"));

//        KeyHandler.getInstance().observeScene(scene);


//        Font.loadFont(getClass().getResourceAsStream("fonts/Pixelfy-ow9yd.ttf"), 14);


//        URL fontURL = getClass().getResource("fonts/Corinthia-Regular.ttf");
//        Font font = Font.loadFont(fontURL.toExternalForm(), 45);

//        Text text = new Text("Hallo Hallo");
//        text.setFont(font);
//        text.setY(50);

//        URL spriteURL = getClass().getResource("images/SpriteStub.bmp");
//        Image sprite = new Image(spriteURL.toExternalForm(), 150, 150, true, true);
//        ImageView mySprite = new ImageView();
//        mySprite.setImage(sprite);
//        Rectangle2D spriteViewPort = new Rectangle2D(50, 0, 50, 50);
//        mySprite.setViewport(spriteViewPort);
//        mySprite.setX(100);
//        mySprite.setY(100);

//        Group root = new Group();
//        root.getChildren().add(mySprite);
//        root.getChildren().add(text);
//        Scene scene = new Scene(root, 850, 600);



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

