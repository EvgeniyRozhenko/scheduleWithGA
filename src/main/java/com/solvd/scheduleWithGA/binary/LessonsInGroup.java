package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class LessonsInGroup {
    private int idLessonInGroup;
    private int lessonId;
    private int groupId;
    private int hoursPerWeek;

    public int getIdLessonInGroup() {
        return idLessonInGroup;
    }

    public void setIdLessonInGroup(int idLessonInGroup) {
        this.idLessonInGroup = idLessonInGroup;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LessonsInGroup)) return false;
        LessonsInGroup that = (LessonsInGroup) o;
        return idLessonInGroup == that.idLessonInGroup && lessonId == that.lessonId && groupId == that.groupId && hoursPerWeek == that.hoursPerWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLessonInGroup, lessonId, groupId, hoursPerWeek);
    }
}
