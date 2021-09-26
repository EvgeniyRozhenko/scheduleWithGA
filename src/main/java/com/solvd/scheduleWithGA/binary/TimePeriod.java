package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class TimePeriod {
    private int idTimePeriod;
    private String timeFrom;
    private String timeTo;

    public int getIdTimePeriod() {
        return idTimePeriod;
    }

    public void setIdTimePeriod(int idTimePeriod) {
        this.idTimePeriod = idTimePeriod;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimePeriod)) return false;
        TimePeriod that = (TimePeriod) o;
        return idTimePeriod == that.idTimePeriod && timeFrom.equals(that.timeFrom) && timeTo.equals(that.timeTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTimePeriod, timeFrom, timeTo);
    }

    @Override
    public String toString() {
        return "TimePeriod{" +
                "idTimePeriod=" + idTimePeriod +
                ", timeFrom='" + timeFrom + '\'' +
                ", timeTo='" + timeTo + '\'' +
                '}';
    }
}
