package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginAddNew {
    public static Scene getLoginScene(Stage stage1) {
        GridPane gridpane = new GridPane();

        Label LoginNewAttendee = new Label("Login Attendee");
        Label usernameLabel = new Label("Username :");
        Label passwordLabel = new Label("Password :");
        Button LoginAtt = new Button("Login");

        TextField usernametxtfield = new TextField();
        TextField passwordtxtfield = new TextField();

        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(LoginNewAttendee,0,0);
        gridpane.add(usernameLabel,0,1);
        gridpane.add(usernametxtfield,1,1);

        gridpane.add(passwordLabel,0,2);
        gridpane.add(passwordtxtfield,1,2);

        gridpane.setAlignment(Pos.CENTER);
        usernametxtfield.setAlignment(Pos.BOTTOM_LEFT);
        passwordtxtfield.setAlignment(Pos.BOTTOM_LEFT);


        gridpane.add(LoginAtt,1,3);
        LoginAtt.setOnAction(actionEvent -> {
           String x = MainFunctions.LoginAttendee(usernametxtfield.getText(),passwordtxtfield.getText());

           if (x.equals("Successful")){
               Label Successful = new Label("Login Successful :)");
               Successful.setFont(Font.font(25));
               gridpane.add(Successful,3,5);
               Button Continue = new Button("Continue");
               Continue.setFont(Font.font(20));
               gridpane.add(Continue,3,7);
               Continue.setOnAction(actionEvent1 -> {
                   Scene AttendeeFunctionss = AttendeeFunctions.getAttFunScene(stage1, usernametxtfield.getText());
                   stage1.setScene(AttendeeFunctionss);
               });
           }
           else if (x.equals("Invalid")){
               Label Failed = new Label("Login Failed :(");
               Failed.setFont(Font.font(25));
               Failed.setStyle("-fx-text-fill:red;");
               gridpane.add(Failed,3,5);
               Button Retry = new Button("Retry !");
               Retry.setFont(Font.font(20));
               gridpane.add(Retry,3,7);
               Retry.setOnAction(actionEvent1 -> {
                   Scene RetryScene = LoginAddNew.getLoginScene(stage1);
                   stage1.setScene(RetryScene);
               });
           }
        });

        Button back = new Button("Back");
        gridpane.add(back,0,9);
        back.setOnAction(actionEvent -> {
            Scene AttOROrgLogin = AttendeeOrOrganizerLogin.getAttendeeOrOrganizerInLoginScene(stage1);
            stage1.setScene(AttOROrgLogin);
        });



        return new Scene(gridpane, 1670,900);
    }
}
