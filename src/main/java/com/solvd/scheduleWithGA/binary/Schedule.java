package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class Schedule {
    private int idSchedule;
    private int timeSlotId;
    private int teacherId;
    private int groupId;
    private int lessonId;
    private int classroomId;

    public Schedule(int idSchedule, int groupId, int lessonId) {
        this.idSchedule = idSchedule;
        this.groupId = groupId;
        this.lessonId = lessonId;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
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
        return idSchedule == schedule.idSchedule && timeSlotId == schedule.timeSlotId
                && teacherId == schedule.teacherId && groupId == schedule.groupId
                && lessonId == schedule.lessonId && classroomId == schedule.classroomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSchedule, timeSlotId, teacherId, groupId, lessonId, classroomId);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "idSchedule=" + idSchedule +
                ", timeSlotId=" + timeSlotId +
                ", teacherId=" + teacherId +
                ", groupId=" + groupId +
                ", lessonId=" + lessonId +
                ", classroomId=" + classroomId +
                '}';
    }
}
