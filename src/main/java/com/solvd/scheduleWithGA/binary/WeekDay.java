package com.solvd.scheduleWithGA.binary;

public class WeekDay {
    private int id;
    private String dayName;

    public WeekDay(int id, String dayName) {
        this.id = id;
        this.dayName = dayName;
    }

    public int getId() {
        return id;
    }

    public String getDayName() {
        return dayName;
    }
}
