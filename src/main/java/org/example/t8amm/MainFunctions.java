package org.example.t8amm;

public class MainFunctions {
    public static String LoginAttendee(String attendeeUsername, String attendeePassword) {
        boolean validAttendee = false;
        Attendee loggedInAttendee = null;

        // Check if credentials match
        for (Attendee attendee : Database.attendeeList) {
            if (attendee.getUsername().equals(attendeeUsername) &&
                    attendee.getPassword().equals(attendeePassword)) {
                return "Successful";
            }
        }
        return "Invalid";


    }

    public static void RegisterAttendee(String Username, String Password, String DateBirth, Gender gender, float Balance, String Address, String interests) {
        Database.attendeeList.add(new Attendee(Username, Password, DateBirth, gender, Balance, Address, interests));
    }

    public static String LoginOrganizer(String OrganizerUsername, String OrganizerPassword) {
        boolean validOragnizer = false;
        Organizer loggedInAttendee = null;

        // Check if credentials match
        for (Organizer organizer : Database.organizerList) {
            if (organizer.getUsername().equals(OrganizerUsername) &&
                    organizer.getPassword().equals(OrganizerPassword)) {
                return "Successful";
            }
        }
        return "Invalid";


    }

    public static void RegisterOrganizer(String username, String password, String dateBirth, Gender gender, float balance, Category category) {
        Database.organizerList.add(new Organizer(username, password, dateBirth, gender, balance, new Event(category)));
    }
}