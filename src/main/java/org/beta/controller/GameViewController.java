package org.beta.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.beta.engine.Renderer;
import org.beta.objects.GameObject;
import org.beta.objects.Orientation;
import org.beta.objects.Player;
import org.beta.objects.Wall;

public class GameViewController {

    @FXML
    private Canvas gameCanvas;

    @FXML
    private BorderPane gameViewPane;

    private final Player player = new Player();
    private final Wall wall = new Wall(Orientation.UPRIGHT);



    /**
     * todo
     * Canvas wird an Pane Größe gebunden und ermöglicht damit den Resize
     */
    private void initializeCanvas() {

//        gameCanvas.widthProperty().bind(gameViewPane.widthProperty());
//        gameCanvas.heightProperty().bind(gameViewPane.heightProperty());
//
//        System.out.println(gameCanvas.widthProperty());
//        System.out.println(gameCanvas.heightProperty());
//        System.out.println(gameViewPane.getWidth());
//        System.out.println(gameViewPane.getHeight());
    }

    @FXML
    public void initialize() {

        initializeCanvas();

        player.setLocation(380, 180);
        wall.setLocation(200, 200);

        Renderer renderer = new Renderer(this.gameCanvas);
        renderer.prepare();
        renderer.addGameObject(player);
        renderer.addGameObject(wall);
        renderer.render();

    }

}
