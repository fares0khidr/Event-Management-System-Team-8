package org.example.t8amm;

import java.util.ArrayList;
import java.util.List;

public class Database  {
    public static List<Attendee> attendeeList = new ArrayList<>(1);
    public static List<Admin> adminList = new ArrayList<>(1);
    public static List<Organizer> organizerList = new ArrayList<>(1);
    public static List<Event> eventList = new ArrayList<>(1);
    public static List<Room> roomList = new ArrayList<>(1);

    static {
        roomList.add(new Room(1, false, 50));
        roomList.add(new Room(2, false, 100));
        roomList.add(new Room(3, true, 100));
        roomList.add(new Room(4, false, 200));
        roomList.add(new Room(5, true, 200));

        adminList.add(new Admin("Admin@Event", "1234","1/10/1988" ,Gender.MALE,200, 24,"Manager"));

        organizerList.add(new Organizer("Organizer1@Event", "4321","4/3/1991" ,Gender.ENGINEER,2400,new Event(Category.Social)));
        organizerList.add(new Organizer("Organizer2@Event", "432","4/3/1992" ,Gender.MALE,2500,new Event(Category.Business)));
        organizerList.add(new Organizer("Organizer3@Event", "127317","7/1/1990" ,Gender.FEMALE,2800,new Event(Category.Educational)));
        organizerList.add(new Organizer("Organizer4@Event", "4321","4/3/1991" ,Gender.MALE,4000,new Event(Category.Entertainment)));
        organizerList.add(new Organizer("Organizer5@Event", "4321","4/3/1991" ,Gender.MALE,2000,new Event(Category.Personal)));

        eventList.add(new Event(Category.Social));
        eventList.add(new Event(Category.Business));
        eventList.add(new Event(Category.Educational));
        eventList.add(new Event(Category.Entertainment));
        eventList.add(new Event(Category.Personal));

        attendeeList.add(new Attendee("johndoe", "pass123", "1990-01-15", Gender.ENGINEER, 2000 ,"StreetDoe", "Likes Social"));
        attendeeList.add(new Attendee("janedoe", "word321", "1992-07-08", Gender.MALE, 2000 ,"StreetDoe", "Likes Business"));
        attendeeList.add(new Attendee("mikebrown", "mike@456", "1985-03-25", Gender.FEMALE, 2000 ,"StreetDoe", "Likes Educational"));
        attendeeList.add(new Attendee("lucysmith", "lucy789", "2000-11-30", Gender.FEMALE,2000 ,"StreetDoe", "Likes Entertainment" ));
        attendeeList.add(new Attendee("alexking", "alexPass", "1995-06-22", Gender.FEMALE,2000 ,"StreetDoe", "Likes Personal"));


    }







}