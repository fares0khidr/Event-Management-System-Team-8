package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewAvalaibleEvents {
    public static Scene getAvScene(Stage stage1,String UsernameInAvEvents) {
        GridPane gridpane = new GridPane();
        Label AvEvents = new Label("Available Events");
        AvEvents.setFont(Font.font(24));
        gridpane.setAlignment(Pos.CENTER);
        for (int i = 0; i < Database.eventList.size(); i++) {
            Label eventLabel = new Label("Event #" + (i + 1) + " - " + Database.eventList.get(i).getCategory());
            eventLabel.setFont(Font.font(20));
            gridpane.add(eventLabel, 0, i);
        }

        Button back = new Button("Back");
        gridpane.add(back,0,11);
        back.setOnAction(actionEvent -> {
            Scene AttFns = AttendeeFunctions.getAttFunScene(stage1,UsernameInAvEvents);
            stage1.setScene(AttFns);
        });


        return new Scene(gridpane, 1670,900);
    }
}
