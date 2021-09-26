package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class Teacher {
    private int idTeacher;
    private String fullName;
    private int specialityId;


    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return idTeacher == teacher.idTeacher && specialityId == teacher.specialityId && fullName.equals(teacher.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher, fullName, specialityId);

    }



    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + idTeacher +
                ", fullName='" + fullName + '\'' +
                ", speciality=" + specialityId +
                '}';
    }
}
