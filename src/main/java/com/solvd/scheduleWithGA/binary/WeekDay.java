package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class WeekDay {
    private int idWeekDay;
    private String dayName;

    public int getIdWeekDay() {
        return idWeekDay;
    }

    public void setIdWeekDay(int idWeekDay) {
        this.idWeekDay = idWeekDay;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeekDay)) return false;
        WeekDay weekDay = (WeekDay) o;
        return idWeekDay == weekDay.idWeekDay && dayName.equals(weekDay.dayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWeekDay, dayName);
    }

    @Override
    public String toString() {
        return "WeekDay{" +
                "idWeekDay=" + idWeekDay +
                ", dayName='" + dayName + '\'' +
                '}';
    }
}
