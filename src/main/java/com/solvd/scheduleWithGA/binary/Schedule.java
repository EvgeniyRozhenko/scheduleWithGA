package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class Schedule {
    private int idSchedule;
    private int timeSlotId;
    private int teacherId;
    private int lessonInGroupId;
    private int classroomId;

    public Schedule(int idSchedule, int lessonInGroupId) {
        this.idSchedule = idSchedule;
        this.lessonInGroupId = lessonInGroupId;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public int getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(int timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getLessonInGroupId() {
        return lessonInGroupId;
    }

    public void setLessonInGroupId(int lessonInGroupId) {
        this.lessonInGroupId = lessonInGroupId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule = (Schedule) o;
        return idSchedule == schedule.idSchedule && timeSlotId == schedule.timeSlotId && teacherId == schedule.teacherId && lessonInGroupId == schedule.lessonInGroupId && classroomId == schedule.classroomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSchedule, timeSlotId, teacherId, lessonInGroupId, classroomId);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "idSchedule=" + idSchedule +
                ", timeSlotId=" + timeSlotId +
                ", teacherId=" + teacherId +
                ", lessonInGroupId=" + lessonInGroupId +
                ", classroomId=" + classroomId +
                '}';
    }
}
