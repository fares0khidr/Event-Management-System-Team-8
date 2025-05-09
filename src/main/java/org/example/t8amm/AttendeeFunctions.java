package org.example.t8amm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AttendeeFunctions {
    public static Scene getAttFunScene(Stage stage3, String Username) {
        GridPane gridpane = new GridPane();

        Label HelloAttendee = new Label("Hello " + Username + " !!");
        HelloAttendee.setFont(Font.font(20));
        Label yourfn = new Label("Your Functions");
        Button AvailableEvents = new Button("View Available Events");
        Button PurchasedTickets = new Button("View Purchased Tickets");
        Button CheckBalance = new Button("Check Balance");
        Button BuyTicket = new Button("Buy Ticket");
        yourfn.setFont(Font.font(23));

        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(HelloAttendee,0,0);
        gridpane.add(yourfn,1,5);

        gridpane.add(AvailableEvents,1,6);
        gridpane.add(BuyTicket,1,9);
        gridpane.add(PurchasedTickets,1,7);
        gridpane.add(CheckBalance,1,8);


        Button back = new Button("Back");
        gridpane.add(back,0,11);
        back.setOnAction(actionEvent -> {
            Scene LoginScene = LoginAddNew.getLoginScene(stage3);
            stage3.setScene(LoginScene);
        });

        AvailableEvents.setOnAction(actionEvent -> {
            Scene AvailableEvent = ViewAvalaibleEvents.getAvScene(stage3,Username);
            stage3.setScene(AvailableEvent);
        });

        PurchasedTickets.setOnAction(actionEvent -> {
            Scene PurchasedTicketss = ViewPurchasedTickets.getPurchasedTicketsScene(stage3, Username);
            stage3.setScene(PurchasedTicketss);
        });

        CheckBalance.setOnAction(actionEvent -> {
            Scene CheckBalancee = ViewCheckBalance.getCheckBalance(stage3, Username);
            stage3.setScene(CheckBalancee);
        });

        BuyTicket.setOnAction(actionEvent -> {
            Scene BuyTicketss = BuyTickets.getBuyTickets(stage3,Username);
            stage3.setScene(BuyTicketss);
        });
        return new Scene(gridpane, 1670,900);
    }
}
