package com.solvd.scheduleWithGA.binary;

public class Lesson {
    private int id;
    private String name;
    private int speciality;
    private int hoursPerWeek;

    public Lesson(int id, String name, Speciality speciality, int hoursPerWeek) {
        this.id = id;
        this.name = name;
        this.speciality = speciality.getId();
        this.hoursPerWeek = hoursPerWeek;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSpeciality() {
        return speciality;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }
}
