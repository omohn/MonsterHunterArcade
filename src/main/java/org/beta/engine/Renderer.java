package org.beta.engine;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.beta.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Renderer {

    Canvas canvas;
    GraphicsContext context;

    List<GameObject> gameObjects= new ArrayList<>();

    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();

    }

    public void addGameObject(GameObject go) {
        gameObjects.add(go);
    }

    public void removeGameObject(GameObject go) {
        gameObjects.remove(go);
    }

    public void clearGameObjects() {
        gameObjects.clear();
    }

    public void render() {



        context.save();

        for (GameObject gameObject : gameObjects) {

            gameObject.doRender(context);

//            context.drawImage(gameObject.getSprite(), gameObject.getX(),
//                    gameObject.getY(), gameObject.getSize(), gameObject.getSize());
//            context.drawImage(gameObject.getSprite(), 50, 0, 51, 51, gameObject.getX(), gameObject.getY(), gameObject.getSize(), gameObject.getSize());
        }

        context.restore();
    }

    public void prepare() {
//        context.setFill( new Color(0.00, 0.00, 1.00, 1.00));
//        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}
