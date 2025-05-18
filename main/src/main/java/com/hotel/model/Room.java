package com.hotel.model;

public class Room {
    private int roomNumber;
    private boolean available;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
