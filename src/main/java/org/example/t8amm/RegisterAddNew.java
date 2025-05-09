package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegisterAddNew {
    public static Scene getRegisterScene(Stage stage2) {
        GridPane gridpane = new GridPane();

        Label btOK = new Label("Add New ?");
        Button organizerButton = new Button("Organizer");
        Button attendeeButton = new Button("Attendee");

        btOK.setAlignment(Pos.CENTER);
        btOK.setFont(Font.font(50));
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(btOK,0,0);
        organizerButton.setFont(Font.font(25));
        attendeeButton.setFont(Font.font(25));

        gridpane.add(organizerButton,10,3);
        gridpane.add(attendeeButton,50,3);

        attendeeButton.setOnAction(actionEvent -> {
            Scene registerScene = AddNewAttendee.getNewAttendee(stage2);
            stage2.setScene(registerScene);
        });

        organizerButton.setOnAction(actionEvent -> {
            Scene registerOScene = AddNewOrganizer.getNewOrganizer(stage2);
            stage2.setScene(registerOScene);
        });

        Button back = new Button("Back");
        gridpane.add(back,0,9);
        back.setOnAction(actionEvent -> {
            HelloApplication h1 = new HelloApplication();
            h1.start(stage2);
        });
        return new Scene(gridpane, 1670,900);
    }
}