package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminMenu {public static Scene getAdminMenu(Stage stage99) {
    GridPane gopo = new GridPane();
    Label lolo = new Label("Admin menu");
    Button btShowRooms = new Button("Show Rooms");
    Button btShowEvents = new Button("Show Events");
    Button btCreateEvents = new Button("Create Events");
    Button btDeleteEvent = new Button("Delete Event");
    Button btUpdateEvent = new Button("Update Event");
    Button btShowOrg = new Button("Show Organizers");
    Button btShowAt= new Button("Show Attendees");
    Button btBack = new Button("Back");

    lolo.setAlignment(Pos.CENTER);
    lolo.setFont(Font.font(50));
    gopo.setAlignment(Pos.CENTER);
    gopo.add(lolo, 0, 0);
    btShowEvents.setFont(Font.font(20));
    btCreateEvents.setFont(Font.font(20));
    btDeleteEvent.setFont(Font.font(20));
    btUpdateEvent.setFont(Font.font(20));
    btShowRooms.setFont(Font.font(20));
    btShowOrg.setFont(Font.font(20));
    btShowAt.setFont(Font.font(20));
    btBack.setFont(Font.font(25));

    gopo.add(btShowRooms, 1, 3);
    gopo.add(btShowEvents, 40, 3);
    gopo.add(btCreateEvents, 80, 3);
    gopo.add(btDeleteEvent, 120, 3);
    gopo.add(btUpdateEvent, 160, 3);
    gopo.add(btShowOrg,200,3);
    gopo.add(btShowAt,240,3);
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
        stage99.setScene(roomScene);

        backButton.setOnAction(ev -> {
            stage99.setScene(getAdminMenu(stage99));
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
        stage99.setScene(eventScene);

        backButton.setOnAction(ev -> {
            stage99.setScene(getAdminMenu(stage99)); // Go back to main menu
        });
    });
    btCreateEvents.setOnAction(e -> {
        GridPane createLayout = new GridPane();
        createLayout.setAlignment(Pos.CENTER);
        createLayout.setVgap(10);

        Label title = new Label("Select Event Category to Create");
        title.setFont(Font.font(25));
        createLayout.add(title, 0, 0);

        // Create buttons for each category
        int row = 1;
        for (Category category : Category.values()) {
            Button categoryButton = new Button(category.toString());
            categoryButton.setFont(Font.font(20));
            createLayout.add(categoryButton, 0, row++);

            categoryButton.setOnAction(ev -> {
                // Create event and show confirmation
                Organizer.createEvent(category); // or replace MainApp with your class
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Event Created");
                alert.setHeaderText(null);
                alert.setContentText("Event with category '" + category + "' created successfully.");
                alert.showAndWait();

                stage99.setScene(getAdminMenu(stage99)); // Go back to main menu
            });
        }

        Button backButton = new Button("Back");
        backButton.setFont(Font.font(20));
        createLayout.add(backButton, 0, row + 1);

        backButton.setOnAction(ev -> stage99.setScene(getAdminMenu(stage99)));

        Scene createScene = new Scene(createLayout, 1670,900);
        stage99.setScene(createScene);
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
            rb.setUserData(i); // Store the index
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
                int selectedIndex = (int) selectedRadio.getUserData();
                Organizer.updateEvent(selectedIndex, selectedCategory);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Event Updated");
                alert.setHeaderText(null);
                alert.setContentText("Event #" + (selectedIndex + 1) + " updated to category '" + selectedCategory + "'.");
                alert.showAndWait();

                stage99.setScene(getAdminMenu(stage99)); // return to main
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Selection");
                alert.setHeaderText(null);
                alert.setContentText("Please select an event and a new category.");
                alert.showAndWait();
            }
        });

        backButton.setOnAction(ev -> stage99.setScene(getAdminMenu(stage99)));

        Scene updateScene = new Scene(updateLayout, 1670,900);
        stage99.setScene(updateScene);
    });
    btDeleteEvent.setOnAction(e -> {
        GridPane deleteLayout = new GridPane();
        deleteLayout.setAlignment(Pos.CENTER);
        deleteLayout.setVgap(10);

        Label title = new Label("Select Event to Delete");
        title.setFont(Font.font(25));
        deleteLayout.add(title, 0, 0);

        ToggleGroup toggleGroup = new ToggleGroup(); // for single selection

        int row = 1;
        for (int i = 0; i < Database.eventList.size(); i++) {
            Event event = Database.eventList.get(i);
            RadioButton rb = new RadioButton("Event " + (i + 1) + " | Category: " + event.getCategory());
            rb.setToggleGroup(toggleGroup);
            rb.setUserData(i); // Store index
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
                Organizer organizer = new Organizer(); // or cast loggedInUser if needed
                organizer.deleteEvent(selectedIndex);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Event Deleted");
                alert.setHeaderText(null);
                alert.setContentText("Event #" + (selectedIndex + 1) + " deleted successfully.");
                alert.showAndWait();

                stage99.setScene(getAdminMenu(stage99)); // Refresh UI
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Selection");
                alert.setHeaderText(null);
                alert.setContentText("Please select an event to delete.");
                alert.showAndWait();
            }
        });

        backButton.setOnAction(ev -> stage99.setScene(getAdminMenu(stage99)));

        Scene deleteScene = new Scene(deleteLayout, 1670,900);
        stage99.setScene(deleteScene);
    });

    btShowOrg.setOnAction(e -> {
        GridPane roomLayout = new GridPane();
        roomLayout.setAlignment(Pos.CENTER);
        roomLayout.setVgap(10);

        Label title = new Label("All Organizers");
        title.setFont(Font.font(30));
        roomLayout.add(title, 0, 0);

        int row = 1;
        for (int i = 0; i < Database.organizerList.size(); i++) {
          Organizer organizer= Database.organizerList.get(i);


            Label roomInfo = new Label(
                    "Organizer " + (i + 1) +
                            " | Username: " + organizer.getUsername() +
                            " | Gender: " + organizer.getGender() +
                            " | DateOfBirth: " + organizer.getDateOfBirth() +
                    " | Balance " + organizer.getBalance()
            );
            roomInfo.setFont(Font.font(20));
            roomLayout.add(roomInfo, 0, row++);
        }

        Button backButton = new Button("Back");
        backButton.setFont(Font.font(20));
        roomLayout.add(backButton, 0, row + 1);

        Scene roomScene = new Scene(roomLayout, 1670,900);
        stage99.setScene(roomScene);

        backButton.setOnAction(ev -> {
            stage99.setScene(getAdminMenu(stage99));
        });
    });

    btShowAt.setOnAction(e -> {
        GridPane roomLayout = new GridPane();
        roomLayout.setAlignment(Pos.CENTER);
        roomLayout.setVgap(10);

        Label title = new Label("All Attendees");
        title.setFont(Font.font(30));
        roomLayout.add(title, 0, 0);

        int row = 1;
        for (int i = 0; i < Database.attendeeList.size(); i++) {
            Attendee attendee= Database.attendeeList.get(i);


            Label roomInfo = new Label(
                    "Attendee " + (i + 1) +
                            " | Username: " + attendee.getUsername() +
                            " | Gender: " + attendee.getGender() +
                            " | DateOfBirth: " + attendee.getDateOfBirth() +
                            " | Balance: " + attendee.getBalance() +
                            " | Address: " + attendee.getAddress() +
                            "| Interests:" + attendee.getInterests()
            );
            roomInfo.setFont(Font.font(20));
            roomLayout.add(roomInfo, 0, row++);
        }

        Button backButton = new Button("Back");
        backButton.setFont(Font.font(20));
        roomLayout.add(backButton, 0, row + 1);

        Scene roomScene = new Scene(roomLayout, 1670,900);
        stage99.setScene(roomScene);

        backButton.setOnAction(ev -> {
            stage99.setScene(getAdminMenu(stage99));
        });
    });

    btBack.setOnAction(e->{ Scene LoginScene = LoginAdmin.getLoginScene(stage99);
        stage99.setScene(LoginScene);}
    );



    return new Scene(gopo, 1670,900);
}
}
