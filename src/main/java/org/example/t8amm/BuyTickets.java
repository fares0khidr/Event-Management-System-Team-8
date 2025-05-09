package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class BuyTickets {
    public static Scene getBuyTickets(Stage stage3, String UsernameAttendee) {
        GridPane gridpane = new GridPane();

        Label Buyticket = new Label("Available Tickets");

        for (int i = 0; i < Database.eventList.size(); i++) {
            Label eventLabel = new Label("Event #" + (i + 1) + " - " + Database.eventList.get(i).getCategory());
            eventLabel.setFont(Font.font(20));
            gridpane.add(eventLabel, 0, i + 1);
        }
        Button BuySocial = new Button("Buy Social event Ticket");
        Button BuyBusiness = new Button("Buy Business event Ticket");
        Button BuyEdu = new Button("Buy Educational event Ticket");
        Button BuyEnt = new Button("Buy Entertainment event Ticket");
        Button BuyPersonal = new Button("Buy Personal event Ticket");

        gridpane.add(BuySocial, 2, 1);
        gridpane.add(BuyBusiness, 2, 2);
        gridpane.add(BuyEdu, 2, 3);
        gridpane.add(BuyEnt, 2, 4);
        gridpane.add(BuyPersonal, 2, 5);

        Label PricingOfAll = new Label("Each Ticket is for $100");
        gridpane.add(PricingOfAll, 7, 7);
        PricingOfAll.setFont(Font.font(20));
        PricingOfAll.setStyle("-fx-text-fill:red;");
        PricingOfAll.setStyle("-fx-underline:true;");


        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(Buyticket, 0, 0);
        Buyticket.setFont(Font.font(30));

        Button back = new Button("Back");
        gridpane.add(back, 0, 15);
        back.setOnAction(actionEvent -> {
            Scene AttFunScene = AttendeeFunctions.getAttFunScene(stage3, UsernameAttendee);
            stage3.setScene(AttFunScene);
        });

        BuySocial.setOnAction(actionEvent -> {
            for (Attendee attendee : Database.attendeeList) {
                if (attendee.getUsername().equals(UsernameAttendee)) {
                    if (attendee.getBalance() >= 100) {
                        attendee.setBalance(attendee.getBalance() - 100);

                        Event selectedEvent = Database.eventList.get(0);
                        Ticket ticket = new Ticket(100, selectedEvent);
                        Organizer.receivePayment(100);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Purchase Successful");
                        alert.setHeaderText(null);
                        alert.setContentText("You bought a ticket for $" + ticket.getPrice() + " for " + selectedEvent.getCategory() + " event.");
                        alert.showAndWait();

                        Attendee.getPurchasedTickets().add(ticket);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Purchase Failed");
                        alert.setHeaderText(null);
                        alert.setContentText("Insufficient balance to buy the ticket.");
                        alert.showAndWait();
                    }
                    break;
                }
            }
        });
        BuyBusiness.setOnAction(actionEvent -> {
            for (Attendee attendee : Database.attendeeList) {
                if (attendee.getUsername().equals(UsernameAttendee)) {
                    if (attendee.getBalance() >= 100) {
                        attendee.setBalance(attendee.getBalance() - 100);

                        Event selectedEvent = Database.eventList.get(1);
                        Ticket ticket = new Ticket(100, selectedEvent);
                        Organizer.receivePayment(100);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Purchase Successful");
                        alert.setHeaderText(null);
                        alert.setContentText("You bought a ticket for $" + ticket.getPrice() + " for " + selectedEvent.getCategory() + " event.");
                        alert.showAndWait();

                        Attendee.getPurchasedTickets().add(ticket);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Purchase Failed");
                        alert.setHeaderText(null);
                        alert.setContentText("Insufficient balance to buy the ticket.");
                        alert.showAndWait();
                    }
                    break;
                }
            }
        });
        BuyEdu.setOnAction(actionEvent -> {
            for (Attendee attendee : Database.attendeeList) {
                if (attendee.getUsername().equals(UsernameAttendee)) {
                    if (attendee.getBalance() >= 100) {
                        attendee.setBalance(attendee.getBalance() - 100);

                        Event selectedEvent = Database.eventList.get(2);
                        Ticket ticket = new Ticket(100, selectedEvent);
                        Organizer.receivePayment(100);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Purchase Successful");
                        alert.setHeaderText(null);
                        alert.setContentText("You bought a ticket for $" + ticket.getPrice() + " for " + selectedEvent.getCategory() + " event.");
                        alert.showAndWait();

                        Attendee.getPurchasedTickets().add(ticket);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Purchase Failed");
                        alert.setHeaderText(null);
                        alert.setContentText("Insufficient balance to buy the ticket.");
                        alert.showAndWait();
                    }
                    break;
                }
            }
        });
        BuyEnt.setOnAction(actionEvent -> {
            for (Attendee attendee : Database.attendeeList) {
                if (attendee.getUsername().equals(UsernameAttendee)) {
                    if (attendee.getBalance() >= 100) {
                        attendee.setBalance(attendee.getBalance() - 100);

                        Event selectedEvent = Database.eventList.get(3);
                        Ticket ticket = new Ticket(100, selectedEvent);
                        Organizer.receivePayment(100);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Purchase Successful");
                        alert.setHeaderText(null);
                        alert.setContentText("You bought a ticket for $" + ticket.getPrice() + " for " + selectedEvent.getCategory() + " event.");
                        alert.showAndWait();

                        Attendee.getPurchasedTickets().add(ticket);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Purchase Failed");
                        alert.setHeaderText(null);
                        alert.setContentText("Insufficient balance to buy the ticket.");
                        alert.showAndWait();
                    }
                    break;
                }
            }
        });
        BuyPersonal.setOnAction(actionEvent -> {
            for (Attendee attendee : Database.attendeeList) {
                if (attendee.getUsername().equals(UsernameAttendee)) {
                    if (attendee.getBalance() >= 100) {
                        attendee.setBalance(attendee.getBalance() - 100);

                        Event selectedEvent = Database.eventList.get(4);
                        Ticket ticket = new Ticket(100, selectedEvent);
                        Organizer.receivePayment(100);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Purchase Successful");
                        alert.setHeaderText(null);
                        alert.setContentText("You bought a ticket for $" + ticket.getPrice() + " for " + selectedEvent.getCategory() + " event.");
                        alert.showAndWait();

                        Attendee.getPurchasedTickets().add(ticket);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Purchase Failed");
                        alert.setHeaderText(null);
                        alert.setContentText("Insufficient balance to buy the ticket.");
                        alert.showAndWait();
                    }
                    break;
                }
            }
        });




        return new Scene(gridpane, 1670,900);
    }
}
