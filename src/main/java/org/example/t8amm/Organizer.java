package org.example.t8amm;


public class Organizer extends User {
    private Event eventType;

    /// Getters & Setters
    public Event getEventType() {
        return eventType;
    }

    public void setEventType(Event eventType) {
        this.eventType = eventType;
    }


    /// Constructors
    public Organizer(Event eventType) {
        this.eventType = eventType;
    }

    public Organizer(){

    }


    /// Methods (Actions) of ORGANIZER
    public void showAvailableRooms() {
        int x;
        System.out.println("All Rooms");
        for (int i = 0; i < Database.roomList.size(); i++) {
            //x = i + 1;
            if (Database.roomList.get(i).getAvailableOrNot() == true) {
                System.out.println("Room " + (i+1));
                System.out.println("Id : " + Database.roomList.get(i).getId());
                System.out.println("Capacity : " + Database.roomList.get(i).getCapacity());
                System.out.println("Status : Available ");
            }
            System.out.print("\n");
        }
    }

    public void showOrganizedEvents(){
        int s;
        System.out.println("All Events");

        for (int i = 0; i < Database.eventList.size(); i++) {
            //s = i + 1;

            System.out.println("Event : " + (i+1));
            System.out.println("Category : " + Database.eventList.get(i).getCategory());
            System.out.print("\n");

        }
    }

    public void showOrganizedAttendees() {
        int s;
        System.out.println("All Events");
        for (int i = 0; i < Database.eventList.size(); i++) {
            //s = i + 1;
            if (Database.eventList.get(i).getCategory() == Database.organizerList.get(i).getEventType().getCategory()) {
                System.out.println("Event : " + i);
                System.out.println("Category : " + Database.eventList.get(i).getCategory());

                System.out.print("\n");
            }
        }
    }



    public static void receivePayment(double amount) {
        Wallet.add(amount);
    }

//crud operations

    public static void createEvent(Category category) {
        Event newEvent = new Event(category);
        Database.eventList.add(newEvent);
        System.out.println("Event with category '" + category + "' created successfully.");
    }

    public void readAllEvents() {
        System.out.println(" All Events ");
        for (int i = 0; i < Database.eventList.size(); i++) {
            System.out.println("Event #" + (i+1 ));
            System.out.println("Category: " + Database.eventList.get(i).getCategory());
            System.out.println();
        }
    }
    public static void updateEvent(int index, Category newCategory) {
        if (index >= 0 && index < Database.eventList.size()) {
            Database.eventList.get(index).setCategory(newCategory);
            System.out.println("Event #" + (index ) + " updated to category '" + newCategory + "'.");
        } else {
            System.out.println("Invalid index. No such event exists.");
        }
    }
    public void deleteEvent(int index) {
        if (index >= 0 && index < Database.eventList.size()) {
            Database.eventList.remove(index);
            System.out.println("Event #" + (index ) + " deleted successfully.");
        } else {
            System.out.println("Invalid index. No such event exists.");
        }
    }

    private Wallet wallet;
    private Event myEvent;

    public Organizer(String username, String password, String dateOfBirth, Gender gender, double balance, Event myEvent) {
        super(username, password, dateOfBirth, gender, balance);
        this.myEvent = myEvent;
        this.wallet = new Wallet(balance);  // each organizer has their own wallet
    }



    public double getBalance() {
        return wallet.getBalance();
    }

    public Event getMyEvent() {
        return myEvent;
    }
}

