package com.solvd.scheduleWithGA.geneticAlgoService;

import java.util.Objects;

public class BunchHelper {
    private int lessonId;
    private int teacherId;
    private int classroomId;

    public BunchHelper(int lessonId, int teacherId, int classroomId) {
        this.lessonId = lessonId;
        this.teacherId = teacherId;
        this.classroomId = classroomId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
        if (!(o instanceof BunchHelper)) return false;
        BunchHelper that = (BunchHelper) o;
        return lessonId == that.lessonId && teacherId == that.teacherId && classroomId == that.classroomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, teacherId, classroomId);
    }
}
