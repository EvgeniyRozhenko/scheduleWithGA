package com.solvd.scheduleWithGA.binary;

public class Teacher {
    private int id;
    private String fullName;
    private int speciality;

    public Teacher(int id, String fullName, Speciality speciality) {
        this.id = id;
        this.fullName = fullName;
        this.speciality = speciality.getId();
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSpeciality() {
        return speciality;
    }
}
