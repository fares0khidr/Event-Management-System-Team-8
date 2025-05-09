package org.example.t8amm;


public class Room {
    private int capacity; /// 50 or 100 or 200
    private int Id;
    boolean AvailableOrNot;


    public boolean getAvailableOrNot() {
        return AvailableOrNot;
    }

    public void setAvailableOrNot(boolean availableOrNot) {
        AvailableOrNot = availableOrNot;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Room() {
    }

    public Room(int id, boolean availableOrNot, int capacity) {
        this.Id = id;
        AvailableOrNot = availableOrNot;
        this.capacity = capacity;
    }
}

