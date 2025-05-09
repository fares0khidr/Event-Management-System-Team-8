package org.example.t8amm;

public class Admin extends User {
    private String role;
    private int WorkingHours;

    /// Setters & Getters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.WorkingHours = workingHours;
    }

    /// Constructors
    public Admin() {
    }

    public Admin(String username, String password, String dateOfBirth, Gender gender,double balance, int workingHours, String role) {
        super(username, password, dateOfBirth, gender,balance);
        this.WorkingHours = workingHours;
        this.role = role;
    }

    /// Methods (Actions) of ADMIN
    public void showRooms() {
        int x;
        System.out.println("All Rooms");
        for (int i = 0; i < Database.roomList.size(); i++) {
            //x = i + 1;
            System.out.println("Room " + (i+1));
            System.out.println("Id : " + Database.roomList.get(i).getId());
            System.out.println("Capacity : " + Database.roomList.get(i).getCapacity());
            System.out.print("Status : ");
            if (!Database.roomList.get(i).getAvailableOrNot()) {
                System.out.println("Reserved");
            } else {
                System.out.println("Available");
            }
            System.out.print("\n");
        }


    }

    public void showAttendee() {
        int y;
        System.out.println("All Attendees");
        for (int i = 0; i < Database.attendeeList.size(); i++) {
            //y = i + 1;
            System.out.println("Attendee " + (i+1));
            System.out.println("Username : " + Database.attendeeList.get(i).getUsername());
            System.out.println("Password : " + Database.attendeeList.get(i).getPassword());
            System.out.println("Date of Birth : " + Database.attendeeList.get(i).getDateOfBirth());
            System.out.println("Balance :$ " + Database.attendeeList.get(i).getBalance());
            System.out.println("Address : " + Database.attendeeList.get(i).getAddress());
            System.out.println("Interest : " + Database.attendeeList.get(i).getInterests());

            System.out.print("\n");
        }
    }

    public void showOrganizers() {
        int z;
        System.out.println("All Organizers");
        for (int i = 0; i < Database.organizerList.size(); i++) {
            //z = i + 1;
            System.out.println("Organizer " + (i+1));
            System.out.println("Username : " + Database.organizerList.get(i).getUsername());
            System.out.println("Password : " + Database.organizerList.get(i).getPassword());
            System.out.println("Date of Birth : " + Database.organizerList.get(i).getDateOfBirth());
            System.out.println("Gender : " + Database.organizerList.get(i).getGender());
            System.out.println("Event Handling : " + Database.organizerList.get(i).getEventType().getCategory());

            System.out.print("\n");
        }
    }

    public void showEvents() {
        int s;
        System.out.println("All Events");
        for (int i = 0; i < Database.eventList.size(); i++) {
            //s = i + 1;
            System.out.println("Event : " + (i+1));
            System.out.println("Category : " + Database.eventList.get(i).getCategory());

            System.out.print("\n");
        }
    }
    //crud operations
// CREATE - Add a new Event (by category)
    public void addEvent(Category category) {
        Event event = new Event(category);
        Database.eventList.add(event);
        System.out.println("Event added successfully with category: " + category);
    }

    // READ - Show all events (already exists as showEvents, but here’s a fresh one if you want)
    public void viewAllEvents() {
        int i = 1;
        for (Event event : Database.eventList) {
            System.out.println("Event " + i + ": Category = " + event.getCategory());
            i++;
        }
    }

    // UPDATE - Change the category of an existing event
    public void updateEventCategory(int index, Category newCategory) {
        if (index >= 0 && index < Database.eventList.size()) {
            Database.eventList.get(index).setCategory(newCategory);
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Invalid event index.");
        }
    }

    // DELETE - Remove an event by index
    public void deleteEvent(int index) {
        if (index >= 0 && index < Database.eventList.size()) {
            Database.eventList.remove(index);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Invalid event index.");
        }
    }

}

