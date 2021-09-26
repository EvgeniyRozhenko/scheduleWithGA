package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class TimeSlot {
    private int idTimeSlot;
    private int timePeriodId;
    private int weekDayId;

    public int getIdTimeSlot() {
        return idTimeSlot;
    }

    public void setIdTimeSlot(int idTimeSlot) {
        this.idTimeSlot = idTimeSlot;
    }

    public int getTimePeriodId() {
        return timePeriodId;
    }

    public void setTimePeriodId(int timePeriodId) {
        this.timePeriodId = timePeriodId;
    }

    public int getWeekDayId() {
        return weekDayId;
    }

    public void setWeekDayId(int weekDayId) {
        this.weekDayId = weekDayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSlot)) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return idTimeSlot == timeSlot.idTimeSlot && timePeriodId == timeSlot.timePeriodId && weekDayId == timeSlot.weekDayId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTimeSlot, timePeriodId, weekDayId);
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "idTimeSlot=" + idTimeSlot +
                ", timePeriodId=" + timePeriodId +
                ", weekDayId=" + weekDayId +
                '}';
    }
}
