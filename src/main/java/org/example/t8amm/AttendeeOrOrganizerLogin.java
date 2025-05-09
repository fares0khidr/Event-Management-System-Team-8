package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AttendeeOrOrganizerLogin {
    public static Scene getAttendeeOrOrganizerInLoginScene(Stage stage0) {
        GridPane gridpane = new GridPane();

        Label btOK = new Label("Which to Login ?");
        Button organizerButton = new Button("Organizer");
        Button attendeeButton = new Button("Attendee");
        Button adminButton = new Button("Admin");
        btOK.setAlignment(Pos.CENTER);
        btOK.setFont(Font.font(50));
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(btOK, 0, 0);
        organizerButton.setFont(Font.font(25));
        attendeeButton.setFont(Font.font(25));
        adminButton.setFont(Font.font(25));

        gridpane.add(organizerButton, 10, 3);
        gridpane.add(attendeeButton, 50, 3);
        gridpane.add(adminButton, 90, 3);

        organizerButton.setOnAction(actionEvent -> {
            Scene LoginOFOrganizer = LoginOrganizer.getLoginScene(stage0);
            stage0.setScene(LoginOFOrganizer);
        });

        attendeeButton.setOnAction(actionEvent -> {
            Scene LoginOFAttendee = LoginAddNew.getLoginScene(stage0);
            stage0.setScene(LoginOFAttendee);
        });

        adminButton.setOnAction(actionEvent -> {
            Scene LoginOfAdmin = LoginAdmin.getLoginScene(stage0);
            stage0.setScene(LoginOfAdmin);
        });

        Button back = new Button("Back");
        gridpane.add(back,0,9);
        back.setOnAction(actionEvent -> {
            HelloApplication h1 = new HelloApplication();
            h1.start(stage0);
        });

        return new Scene(gridpane, 1670,900);
    }
}
