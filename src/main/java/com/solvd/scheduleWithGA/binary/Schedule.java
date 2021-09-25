package com.solvd.scheduleWithGA.binary;

public class Schedule {
    private int id;
    private int lessonId;
    private int teacherId;
    private int weekDayId;
    private int timeSlotOfLesson;

    public Schedule(int id, Lesson lesson, Teacher teacher, WeekDay weekDay, int timeSlotOfLesson) {
        this.id = id;
        this.lessonId = lesson.getId();
        this.teacherId = teacher.getId();
        this.weekDayId = weekDay.getId();
        this.timeSlotOfLesson = timeSlotOfLesson;
    }

    public int getId() {
        return id;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getWeekDayId() {
        return weekDayId;
    }

    public int getTimeSlotOfLesson() {
        return timeSlotOfLesson;
    }
}
