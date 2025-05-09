package org.example.t8amm;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class AddNewAttendee {
    public static Scene getNewAttendee(Stage stage3) {
        GridPane gridpane = new GridPane();

        Label RegisteringNewAttendee = new Label("Registering New Attendee");
        Label usernameLabel = new Label("Username :");
        Label passwordLabel = new Label("Password :");
        Label DateOfBirthLabel = new Label("Date Of Birth :");
        Label genderLabel = new Label("Gender :");
        Label balanceLabel = new Label("Balance :");
        Label addressLabel = new Label("Address :");
        Label interestsLabel = new Label("Interests :");

        TextField usernametxtfield = new TextField();
        TextField passwordtxtfield = new TextField();
        TextField DateOfBirthtxtfield = new TextField();
        TextField balancetxtfield = new TextField();
        TextField addresstxtfield = new TextField();
        TextField intereststxtfield = new TextField();

        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        RadioButton engineerRadio = new RadioButton("Engineer");
        ToggleGroup genderGroup = new ToggleGroup();

        // Assign the group to both radio buttons
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        engineerRadio.setToggleGroup(genderGroup);

        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(RegisteringNewAttendee,0,0);
        gridpane.add(usernameLabel,0,1);
        gridpane.add(usernametxtfield,1,1);


        gridpane.add(passwordLabel,0,2);
        gridpane.add(passwordtxtfield,1,2);

        gridpane.add(DateOfBirthLabel,0,3);
        gridpane.add(DateOfBirthtxtfield,1,3);

        gridpane.add(genderLabel,0,4);

        HBox genderBox = new HBox(10, maleRadio, femaleRadio, engineerRadio);

        gridpane.add(genderBox, 1, 4);
        gridpane.add(balanceLabel,0,5);
        gridpane.add(balancetxtfield,1,5);

        gridpane.add(addressLabel,0,6);
        gridpane.add(addresstxtfield,1,6);

        gridpane.add(interestsLabel,0,7);
        gridpane.add(intereststxtfield,1,7);

        gridpane.setAlignment(Pos.CENTER);
        usernametxtfield.setAlignment(Pos.BOTTOM_LEFT);
        passwordtxtfield.setAlignment(Pos.BOTTOM_LEFT);
        DateOfBirthtxtfield.setAlignment(Pos.BOTTOM_LEFT);
        balancetxtfield.setAlignment(Pos.BOTTOM_LEFT);
        addresstxtfield.setAlignment(Pos.BOTTOM_LEFT);
        intereststxtfield.setAlignment(Pos.BOTTOM_LEFT);


        Button Register = new Button("Register");
        gridpane.add(Register,1,8);
        Register.setOnAction(actionEvent -> {
            Float balance;
            try {
                balance = Float.valueOf(balancetxtfield.getText());
            } catch (NumberFormatException e) {
                gridpane.add(new Label("Enter Numbers in Balance!!"), 1,9);
                return;
            }
            RadioButton selectedRadio = (RadioButton) genderGroup.getSelectedToggle();

            if (usernametxtfield.getText().isEmpty() || passwordtxtfield.getText().isEmpty() || DateOfBirthtxtfield.getText().isEmpty() || selectedRadio.getText() == null || balancetxtfield.getText().isEmpty() || addresstxtfield.getText().isEmpty()|| intereststxtfield.getText().isEmpty()) {
                System.out.println("HIIIIISIASSE");
                Label FillBlank = new Label("Fill ALL Textfields !");
                gridpane.add(FillBlank,2,9);
            }
            else {
                String genderText = selectedRadio.getText().toUpperCase(); // e.g., "MALE"
                Gender genAtt = Gender.valueOf(genderText);

                MainFunctions.RegisterAttendee(usernametxtfield.getText(), passwordtxtfield.getText(), DateOfBirthtxtfield.getText(), genAtt, balance, addresstxtfield.getText(), intereststxtfield.getText());
                Button Continue = new Button("Continue to Login :)");
                gridpane.add(Continue, 2, 9);
                Continue.setOnAction(actionEvent1 -> {
                    Scene BackToLoginScene = LoginAddNew.getLoginScene(stage3);
                    stage3.setScene(BackToLoginScene);
                });
            }
        });



        Button back = new Button("Back");
        gridpane.add(back,0,13);
        back.setOnAction(actionEvent -> {
            Scene registerScene = RegisterAddNew.getRegisterScene(stage3);
            stage3.setScene(registerScene);
        });



        return new Scene(gridpane, 1670,900);

    }
}
