package com.solvd.scheduleWithGA.binary;

import java.util.ArrayList;
import java.util.Objects;

public class Lesson {
    private int idLesson;
    private String lessonName;
    private int specialityId;
    private ArrayList<Integer> teachersIds;

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson)) return false;
        Lesson lesson = (Lesson) o;
        return idLesson == lesson.idLesson && specialityId == lesson.specialityId && lessonName.equals(lesson.lessonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLesson, lessonName, specialityId);
    }

    public ArrayList<Integer> getTeachersIds() {
        return teachersIds;
    }

    public void setTeachersIds(ArrayList<Integer> teachersIds) {
        this.teachersIds = teachersIds;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "idLesson=" + idLesson +
                ", lessonName='" + lessonName + '\'' +
                ", specialityId=" + specialityId +
                ", teachersIds=" + teachersIds +
                '}';
    }
}
