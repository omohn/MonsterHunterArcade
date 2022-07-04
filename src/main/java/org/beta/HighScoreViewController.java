package org.beta;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class HighScoreViewController implements Initializable {

    @FXML
    private ScrollPane sp_main;

    @FXML
    private Server server;

    @FXML
    private Button button_send;

    @FXML
    private TextField tf_message;

    @FXML
    private VBox vbox_highscores;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try{
            server= new Server (new ServerSocket(5000));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error while creating server!");
        }

        vbox_highscores.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sp_main.setVvalue((Double) t1);
            }
        });

        server.receiveHighscoreFromClient(vbox_highscores);
        button_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String messageToSend = tf_message.getText();
                if(!messageToSend.isEmpty()){
                    HBox hbox = new HBox();
                    hbox.setAlignment(Pos.CENTER_RIGHT);
                    hbox.setPadding(new Insets(5, 5, 5, 10));

                    Text text = new Text(messageToSend);
                    TextFlow textFlow = new TextFlow();
                    //creat some styling objects
                    textFlow.setStyle("-fx-color: rgb(239,242,255);" + "-fx-background-color: rgb(15,125,242);");
                    textFlow.setPadding(new Insets( 5, 10, 5, 10));
                    text.setFill(Color.color(0.934, 0.945, 0.996));
                    //integrate the Highscore in the old ones
                    hbox.getChildren().add(textFlow);
                    vbox_highscores.getChildren().add(hbox);
                    //send it to server and clear up the textfield
                    server.sendMessageToClient(messageToSend);
                    tf_message.clear();

                }
            }
        });


    }
    public static void addLabel(String messageFromClient, VBox vbox){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5, 5, 5, 10));
        Text text = new Text(messageFromClient);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-color: rgb(239,242,255);" + "-fx-background-color: rgb(15,125,242);");

        textFlow.setPadding(new Insets(5, 5, 5, 10));
        hBox.getChildren().add(textFlow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(hBox);
            }
        });

    }

    @FXML
    private void switchToStartScreenView() throws IOException{
        App.setRoot("startScreenView");
    }

}
