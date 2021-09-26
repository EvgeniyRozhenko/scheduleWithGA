package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class Classroom {
    private int idRoom;
    private int roomNumber;
    private int capacity;

    public Classroom(int idRoom, int roomNumber, int capacity) {
        this.idRoom = idRoom;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classroom)) return false;
        Classroom classroom = (Classroom) o;
        return idRoom == classroom.idRoom && roomNumber == classroom.roomNumber && capacity == classroom.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, roomNumber, capacity);
    }
}
