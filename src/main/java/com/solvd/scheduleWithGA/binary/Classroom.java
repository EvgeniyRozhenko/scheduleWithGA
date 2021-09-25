package com.solvd.scheduleWithGA.binary;

public class Classroom {
    private int roomId;
    private String roomNumber;
    private int capacity;

    public Classroom(int roomId, String roomNumber, int capacity) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public int getRoomCapacity() {
        return this.capacity;
    }
}
