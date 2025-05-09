package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ViewPurchasedTickets {
    public static Scene getPurchasedTicketsScene(Stage stage3, String UsernameAttendee) {
        GridPane gridpane = new GridPane();

        Label yourPurchasedTickets = new Label("Your Purchased Tickets : ");
        if (Attendee.getPurchasedTickets().isEmpty()) {
            Label notPurchased = new Label(UsernameAttendee + " has not purchased any tickets");
            notPurchased.setFont(Font.font(20));
            gridpane.add(notPurchased,0,1);
        } else {
            for (int i = 0; i < Attendee.getPurchasedTickets().size(); i++) {
                Label TicketLabel = new Label("Ticket " + (i + 1) + ": $" + Attendee.getPurchasedTickets().get(i).getPrice() + " for Event: " + Attendee.getPurchasedTickets().get(i).getEvent().getCategory());
                TicketLabel.setFont(Font.font(20));
                gridpane.add(TicketLabel, 0, i +1);
            }
        }

        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(yourPurchasedTickets, 0, 0);
        yourPurchasedTickets.setFont(Font.font(30));
        
        Button back = new Button("Back");
        gridpane.add(back, 0, 19);
        back.setOnAction(actionEvent -> {
            Scene AttFunScene = AttendeeFunctions.getAttFunScene(stage3,UsernameAttendee);
            stage3.setScene(AttFunScene);
        });


        return new Scene(gridpane, 1670,900);
    }
}
