package org.example.t8amm;

import java.util.ArrayList;
import java.util.List;

public class Attendee extends User{
    private float balance;
    private String Address;
    private String Interests;
    private static List<Ticket> purchasedTickets;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getInterests() {
        return Interests;
    }

    public void setInterests(String interests) {
        this.Interests = interests;
    }

    public Attendee(String username, String password, String dateOfBirth, Gender gender, float balance, String address, String interests) {
        super(username, password, dateOfBirth, gender,balance);
        this.balance = balance;
        Address = address;
        Interests = interests;
        this.purchasedTickets = new ArrayList<>();
    }

    public static List<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }
    public boolean buyTicket(Ticket ticket, Organizer organizer) {
        if (wallet.deduct(ticket.getPrice())) {
            organizer.receivePayment(ticket.getPrice());
            System.out.println(Username + " bought a ticket for $" + ticket.getPrice());
            purchasedTickets.add(ticket);
            return true;
        } else {
            System.out.println(Username + " does not have enough balance to buy the ticket.");
            return false;
        }
    }
    public void printPurchasedTickets() {
        if (purchasedTickets.isEmpty()) {
            System.out.println(Username + " has not purchased any tickets.");
        } else {
            System.out.println(Username + "'s purchased tickets:");
            for (int i = 0; i < purchasedTickets.size(); i++) {
                Ticket ticket = purchasedTickets.get(i);
                System.out.println("Ticket " +(i+1)+ ": $" + ticket.getPrice()+" for Event: " + ticket.getEvent().getCategory());
            }
        }
    }

}
