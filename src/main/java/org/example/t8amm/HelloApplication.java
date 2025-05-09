package org.example.t8amm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage1) {
        GridPane gridpane = new GridPane();

        Label btOK = new Label("Welcome to Our Event System!");
        Button Login = new Button("Login");
        Button Register = new Button("Register");

        btOK.setAlignment(Pos.CENTER);
        btOK.setFont(Font.font(50));
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(btOK,0,0);
        Login.setFont(Font.font(25));
        Register.setFont(Font.font(25));

        gridpane.add(Login,10,3);
        gridpane.add(Register,50,3);


        Scene scene = new Scene(gridpane,1670,900);
        stage1.setTitle("Our Event Management System");
        stage1.setScene(scene);
        stage1.show();

        Register.setOnAction(actionEvent -> {
            Scene registerScene = RegisterAddNew.getRegisterScene(stage1);
            stage1.setScene(registerScene);
        });

        Login.setOnAction(actionEvent -> {
            Scene loginScene = AttendeeOrOrganizerLogin.getAttendeeOrOrganizerInLoginScene(stage1);
            stage1.setScene(loginScene);
        });

    }

    public static void main(String[] args) {
        HelloApplication.launch();
    }
}

