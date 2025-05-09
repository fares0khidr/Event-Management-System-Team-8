package org.example.t8amm;


public class Ticket {
    private double price;
    private Event event;

    public Ticket(double price, Event event) {
        this.price = price;
        this.event = event;
    }

    public double getPrice() {
        return price;
    }
    public Event getEvent() {
        return event;
    }
}
