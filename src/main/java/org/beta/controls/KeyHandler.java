package org.beta.controls;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class KeyHandler {

    private static KeyHandler instance = new KeyHandler();
    private static Scene scene;
    private static final Set<KeyCode> keysCurrentlyDown = new HashSet<>();

    private KeyHandler() {
    }

    public static KeyHandler getInstance() {
        return instance;
    }

    public void observeScene(Scene scene) {
        clearKeys();
        removeCurrentKeyHandlers();
        setScene(scene);
    }

    private void clearKeys() {
        keysCurrentlyDown.clear();
    }

    private void removeCurrentKeyHandlers() {
        if (scene != null) {
            KeyHandler.scene.setOnKeyPressed(null);
            KeyHandler.scene.setOnKeyReleased(null);
        }
    }

    private void setScene(Scene scene) {
        KeyHandler.scene = scene;
        KeyHandler.scene.setOnKeyPressed((keyEvent -> {
            keysCurrentlyDown.add(keyEvent.getCode());
        }));
        KeyHandler.scene.setOnKeyReleased((keyEvent -> {
            keysCurrentlyDown.remove(keyEvent.getCode());
        }));
    }

    public boolean isDown(KeyCode keyCode) {
        return keysCurrentlyDown.contains(keyCode);
    }

    @Override
    public String toString() {
        StringBuilder keysDown = new StringBuilder("KeyHandler on scene (").append(scene).append(")");
        for (KeyCode code : keysCurrentlyDown) {
            keysDown.append(code.getName()).append(" ");
        }
        return keysDown.toString();
    }
}
