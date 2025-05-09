package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewCheckBalance {
    public static Scene getCheckBalance(Stage stage1, String UsernameInAvEvents) {
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);

        for (int i = 0; i < Database.attendeeList.size(); i++) {
            if (UsernameInAvEvents.equals(Database.attendeeList.get(i).getUsername())) {
                Label Balance = new Label("Balance : " + "$" + Database.attendeeList.get(i).getBalance());
                Balance.setFont(Font.font(20));
                gridpane.add(Balance, 0, i);
            }
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
