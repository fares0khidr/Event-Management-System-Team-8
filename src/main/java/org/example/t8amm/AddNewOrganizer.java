package org.example.t8amm;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddNewOrganizer {
    public static Scene getNewOrganizer(Stage stage3) {
        GridPane gridpane = new GridPane();

        Label RegisteringNewOrganizer = new Label("Registering New Organizer");
        Label usernameLabel = new Label("Username :");
        Label passwordLabel = new Label("Password :");
        Label DateOfBirthLabel = new Label("Date Of Birth :");
        Label genderLabel = new Label("Gender :");
        Label balanceLabel = new Label("Balance :");
        Label categoryLabel = new Label("Event Category :");

        TextField usernametxtfield = new TextField();
        TextField passwordtxtfield = new TextField();
        TextField DateOfBirthtxtfield = new TextField();
        TextField balancetxtfield = new TextField();

        ComboBox<Category> categoryComboBox = new ComboBox<>(FXCollections.observableArrayList(Category.values()));
        categoryComboBox.setPromptText("Select Category");

        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        RadioButton engineerRadio = new RadioButton("Engineer");
        ToggleGroup genderGroup = new ToggleGroup();

        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        engineerRadio.setToggleGroup(genderGroup);

        gridpane.setHgap(5);
        gridpane.setVgap(5);

        gridpane.add(RegisteringNewOrganizer, 0, 0);
        gridpane.add(usernameLabel, 0, 1);
        gridpane.add(usernametxtfield, 1, 1);

        gridpane.add(passwordLabel, 0, 2);
        gridpane.add(passwordtxtfield, 1, 2);

        gridpane.add(DateOfBirthLabel, 0, 3);
        gridpane.add(DateOfBirthtxtfield, 1, 3);

        gridpane.add(genderLabel, 0, 4);
        HBox genderBox = new HBox(10, maleRadio, femaleRadio, engineerRadio);
        gridpane.add(genderBox, 1, 4);

        gridpane.add(balanceLabel, 0, 5);
        gridpane.add(balancetxtfield, 1, 5);

        gridpane.add(categoryLabel, 0, 6);
        gridpane.add(categoryComboBox, 1, 6);

        gridpane.setAlignment(Pos.CENTER);
        usernametxtfield.setAlignment(Pos.BOTTOM_LEFT);
        passwordtxtfield.setAlignment(Pos.BOTTOM_LEFT);
        DateOfBirthtxtfield.setAlignment(Pos.BOTTOM_LEFT);
        balancetxtfield.setAlignment(Pos.BOTTOM_LEFT);

        Button Register = new Button("Register");
        gridpane.add(Register, 1, 8);

        Register.setOnAction(actionEvent -> {
            Float balance; //wrapper m4 primitive 3aks ma el compiler 3ayz 34an mzage gayb ene asta5dem valueOf method
            try {
                balance = Float.valueOf(balancetxtfield.getText()); //bn7awel el text ele katabnaha fel balance l Float 34an n3raf n4a8al el 4o8l
            } catch (NumberFormatException e) {
                gridpane.add(new Label("Enter Numbers in Balance!!"), 1, 9); //incase eno kan kateb 7aga mayenfaa34 tetketeb fel balance ( esm awl 7ob f 7yato masalan )
                return;
            }

            RadioButton selectedRadio = (RadioButton) genderGroup.getSelectedToggle();
            Category selectedCategory = categoryComboBox.getValue();

            if (usernametxtfield.getText().isEmpty() || passwordtxtfield.getText().isEmpty()
                    || DateOfBirthtxtfield.getText().isEmpty() || selectedRadio == null
                    || balancetxtfield.getText().isEmpty() || selectedCategory == null) {

                gridpane.add(new Label("Fill ALL Textfields including Category!"), 2, 9);
            } else {
                String genderText = selectedRadio.getText().toUpperCase(); //34an el enum bta3na kolo capital letters t2reban feh 7ad kan m7tago kda f 3amalo f m4 habawaz el code bta3k y peter do not worry
                Gender genOrg = Gender.valueOf(genderText); //34an n3raf nb3ato lel method ele fel mainfunctions

                MainFunctions.RegisterOrganizer(
                        usernametxtfield.getText(),
                        passwordtxtfield.getText(),
                        DateOfBirthtxtfield.getText(),
                        genOrg,
                        balance,
                        selectedCategory
                );

                Button Continue = new Button("Continue to Login :)");
                gridpane.add(Continue, 2, 10);
                Continue.setOnAction(actionEvent1 -> {
                    Scene BackToLoginScene = LoginOrganizer.getLoginScene(stage3); //zaye ma by3melo fel websites el rw4a + law m3mlt4 kda el method bta3t show balance fel organizer menu ana mo3tamed feha 3ala en ana 3amel log in f 3rft awsal kda el denya hatboz w el code ydrab w has2at fa mfe4 da3e
                    stage3.setScene(BackToLoginScene);
                });
            }
        });

        Button back = new Button("Back");
        gridpane.add(back, 0, 13);
        back.setOnAction(actionEvent -> {
            Scene registerScene = RegisterAddNew.getRegisterScene(stage3);
            stage3.setScene(registerScene);
        });

        return new Scene(gridpane, 1670,900);
    }
}
