package com.solvd.scheduleWithGA.binary;

public class LessonsInGroup {
    private int id;
    private int amountOfHours;
    private int lessonId;

    public LessonsInGroup(int id, int amountOfHours, Lesson lesson) {
        this.id = id;
        this.amountOfHours = amountOfHours;
        this.lessonId = lesson.getId();
    }

    public int getId() {
        return id;
    }

    public int getAmountOfHours() {
        return amountOfHours;
    }

    public int getLessonId() {
        return lessonId;
    }
}
