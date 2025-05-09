package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OrganizerMenu {
    public static Scene getOrganizerMenu(Stage stage55) {
        GridPane gopo = new GridPane();
        Label lolo = new Label("Organizer menu");
        Button btShowRooms = new Button("Show Rooms");
        Button btShowEvents = new Button("Show Events");
        Button btCreateEvents = new Button("Create Events");
        Button btDeleteEvent = new Button("Delete Event");
        Button btUpdateEvent = new Button("Update Event");
        Button btShowBal = new Button("Show Balance");
        Button btBack = new Button("Back");

        lolo.setAlignment(Pos.CENTER);
        lolo.setFont(Font.font(50));
        gopo.setAlignment(Pos.CENTER);
        gopo.add(lolo, 0, 0);
        btShowEvents.setFont(Font.font(25));
        btCreateEvents.setFont(Font.font(25));
        btDeleteEvent.setFont(Font.font(25));
        btUpdateEvent.setFont(Font.font(25));
        btShowRooms.setFont(Font.font(25));
        btShowBal.setFont(Font.font(25));
        btBack.setFont(Font.font(25));

        gopo.add(btShowRooms, 10, 3);
        gopo.add(btShowEvents, 50, 3);
        gopo.add(btCreateEvents, 90, 3);
        gopo.add(btDeleteEvent, 130, 3);
        gopo.add(btUpdateEvent, 170, 3);
        gopo.add(btShowBal,210,3); //kolo zaye b3do bnzawed 40 kol mara
        gopo.add(btBack,0,4);

        btShowRooms.setOnAction(e -> {
            GridPane roomLayout = new GridPane();
            roomLayout.setAlignment(Pos.CENTER);
            roomLayout.setVgap(10);

            Label title = new Label("All Rooms");
            title.setFont(Font.font(30));
            roomLayout.add(title, 0, 0);

            int row = 1;
            for (int i = 0; i < Database.roomList.size(); i++) {
                Room room = Database.roomList.get(i);
                String status = room.getAvailableOrNot() ? "Available" : "Not Available";

                Label roomInfo = new Label(
                        "Room " + (i + 1) +
                                " | ID: " + room.getId() +
                                " | Capacity: " + room.getCapacity() +
                                " | Status: " + status
                );
                roomInfo.setFont(Font.font(20));
                roomLayout.add(roomInfo, 0, row++);
            }

            Button backButton = new Button("Back");
            backButton.setFont(Font.font(20));
            roomLayout.add(backButton, 0, row + 1);

            Scene roomScene = new Scene(roomLayout, 1670,900);
            stage55.setScene(roomScene);

            backButton.setOnAction(ev -> {
                stage55.setScene(getOrganizerMenu(stage55));
            });
        });
        btShowEvents.setOnAction(e -> {
            GridPane eventLayout = new GridPane();
            eventLayout.setAlignment(Pos.CENTER);
            eventLayout.setVgap(10);

            Label title = new Label("All Events");
            title.setFont(Font.font(30));
            eventLayout.add(title, 0, 0);

            int row = 1;
            for (int i = 0; i < Database.eventList.size(); i++) {
                Event event = Database.eventList.get(i);

                Label eventInfo = new Label("Event " + (i + 1) + " | Category: " + event.getCategory());
                eventInfo.setFont(Font.font(20));
                eventLayout.add(eventInfo, 0, row++);
            }

            Button backButton = new Button("Back");
            backButton.setFont(Font.font(20));
            eventLayout.add(backButton, 0, row + 1);

            Scene eventScene = new Scene(eventLayout, 1670,900);
            stage55.setScene(eventScene);

            backButton.setOnAction(ev -> {
                stage55.setScene(getOrganizerMenu(stage55));
            });
        });
        btCreateEvents.setOnAction(e -> {
            GridPane createLayout = new GridPane();
            createLayout.setAlignment(Pos.CENTER);
            createLayout.setVgap(10);

            Label title = new Label("Select Event Category to Create");
            title.setFont(Font.font(25));
            createLayout.add(title, 0, 0);


            int row = 1;
            for (Category category : Category.values()) { // for loop 3ala 3adad el categories ele fel enum
                Button categoryButton = new Button(category.toString()); //bygeb esm kol wa7da
                categoryButton.setFont(Font.font(20));
                createLayout.add(categoryButton, 0, row++); //row++ hna w fe ele fo2 34an kol mara ynzel l t7t

                categoryButton.setOnAction(ev -> {
                    Organizer.createEvent(category); //byb3atlo anhy button ele dosna 3aleha
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Event Created");
                    alert.setHeaderText(null);
                    alert.setContentText("Event with category '" + category + "' created successfully.");
                    alert.showAndWait();

                    stage55.setScene(getOrganizerMenu(stage55));
                });
            }

            Button backButton = new Button("Back");
            backButton.setFont(Font.font(20));
            createLayout.add(backButton, 0, row + 1);

            backButton.setOnAction(ev -> stage55.setScene(getOrganizerMenu(stage55)));

            Scene createScene = new Scene(createLayout, 1670,900);
            stage55.setScene(createScene);
        });
        btUpdateEvent.setOnAction(e -> {
            GridPane updateLayout = new GridPane();
            updateLayout.setAlignment(Pos.CENTER);
            updateLayout.setVgap(10);

            Label title = new Label("Select Event to Update");
            title.setFont(Font.font(25));
            updateLayout.add(title, 0, 0);

            ToggleGroup toggleGroup = new ToggleGroup();
            int row = 1;

            for (int i = 0; i < Database.eventList.size(); i++) {
                Event event = Database.eventList.get(i);
                RadioButton rb = new RadioButton("Event " + (i + 1) + ": " + event.getCategory());
                rb.setToggleGroup(toggleGroup);
                rb.setUserData(i);
                updateLayout.add(rb, 0, row++);
            }

            ComboBox<Category> categoryComboBox = new ComboBox<>();
            categoryComboBox.getItems().addAll(Category.values());
            updateLayout.add(new Label("Select New Category:"), 0, row++);
            updateLayout.add(categoryComboBox, 0, row++);

            Button updateBtn = new Button("Update Selected Event");
            updateLayout.add(updateBtn, 0, row++);

            Button backButton = new Button("Back");
            backButton.setFont(Font.font(20));
            updateLayout.add(backButton, 0, row++);

            updateBtn.setOnAction(ev -> {
                RadioButton selectedRadio = (RadioButton) toggleGroup.getSelectedToggle();
                Category selectedCategory = categoryComboBox.getValue();

                if (selectedRadio != null && selectedCategory != null) {
                    int selectedIndex = (int) selectedRadio.getUserData(); //bn assign el selectedindx l rakam el category ele das 3aleh 34an n3raf nb3ato lel function ele fel organizer
                    Organizer.updateEvent(selectedIndex, selectedCategory);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Event Updated");
                    alert.setHeaderText(null);
                    alert.setContentText("Event #" + (selectedIndex + 1) + " updated to category '" + selectedCategory + "'.");
                    alert.showAndWait();

                    stage55.setScene(getOrganizerMenu(stage55));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Missing Selection");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select an event and a new category.");
                    alert.showAndWait();
                }
            });

            backButton.setOnAction(ev -> stage55.setScene(getOrganizerMenu(stage55)));

            Scene updateScene = new Scene(updateLayout, 1670,900);
            stage55.setScene(updateScene);
        });
        btDeleteEvent.setOnAction(e -> {
            GridPane deleteLayout = new GridPane();
            deleteLayout.setAlignment(Pos.CENTER);
            deleteLayout.setVgap(10);

            Label title = new Label("Select Event to Delete");
            title.setFont(Font.font(25));
            deleteLayout.add(title, 0, 0);

            ToggleGroup toggleGroup = new ToggleGroup();

            int row = 1;
            for (int i = 0; i < Database.eventList.size(); i++) {
                Event event = Database.eventList.get(i);
                RadioButton rb = new RadioButton("Event " + (i + 1) + " | Category: " + event.getCategory());
                rb.setToggleGroup(toggleGroup);
                rb.setUserData(i);
                rb.setFont(Font.font(20));
                deleteLayout.add(rb, 0, row++);
            }

            Button confirmDelete = new Button("Delete Selected Event");
            confirmDelete.setFont(Font.font(20));
            deleteLayout.add(confirmDelete, 0, row++);

            Button backButton = new Button("Back");
            backButton.setFont(Font.font(20));
            deleteLayout.add(backButton, 0, row++);

            confirmDelete.setOnAction(ev -> {
                RadioButton selected = (RadioButton) toggleGroup.getSelectedToggle();
                if (selected != null) {
                    int selectedIndex = (int) selected.getUserData();
                    Organizer organizer = new Organizer(); // 3amalna new object 34an n3raf n access el method ele hya deletevent
                    organizer.deleteEvent(selectedIndex);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Event Deleted");
                    alert.setHeaderText(null);
                    alert.setContentText("Event #" + (selectedIndex + 1) + " deleted successfully.");
                    alert.showAndWait();

                    stage55.setScene(getOrganizerMenu(stage55)); // Refresh UI
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("No Selection");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select an event to delete.");
                    alert.showAndWait();
                }
            });

            backButton.setOnAction(ev -> stage55.setScene(getOrganizerMenu(stage55)));

            Scene deleteScene = new Scene(deleteLayout, 1670,900);
            stage55.setScene(deleteScene);
        });

        btShowBal.setOnAction(e -> {
            Organizer org = LoginOrganizer.loggedInOrganizer;

            if (org != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Balance Information");
                alert.setHeaderText("Organizer Balance");
                alert.setContentText("Your current balance is: $" + org.getBalance());
                alert.showAndWait();
            } //kont h3ml else if bas I don't need it bec he has to be logged in so he can reach this scene , I  guess I had to do this in the previous methods bas mkasel 5las
        });
        btBack.setOnAction(e->{ Scene LoginScene = LoginOrganizer.getLoginScene(stage55);
        stage55.setScene(LoginScene);}
        );


        return new Scene(gopo, 1670,900);
    }
}
