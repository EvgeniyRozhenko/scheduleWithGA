package com.solvd.scheduleWithGA.binary;

import java.util.ArrayList;
import java.util.Objects;

public class ClassGroup {
    private int idClassGroup;
    private String groupName;
    private int groupSize;
    private ArrayList<Integer> lessonsIds;

    public ArrayList<Integer> getLessonsIds() {
        return lessonsIds;
    }

    public void setLessonsIds(ArrayList<Integer> lessonsIds) {
        this.lessonsIds = lessonsIds;
    }

    public int getIdClassGroup() {
        return idClassGroup;
    }

    public void setIdClassGroup(int idClassGroup) {
        this.idClassGroup = idClassGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getRandomLessonId() {
        return lessonsIds.get((int) (lessonsIds.size() * Math.random()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassGroup)) return false;
        ClassGroup that = (ClassGroup) o;
        return idClassGroup == that.idClassGroup && groupSize == that.groupSize && groupName.equals(that.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClassGroup, groupName, groupSize);
    }

    @Override
    public String toString() {
        return "ClassGroup{" +
                "idClassGroup=" + idClassGroup +
                ", groupName='" + groupName + '\'' +
                ", groupSize=" + groupSize +
                ", lessonsIds=" + lessonsIds +
                '}';
    }
}
