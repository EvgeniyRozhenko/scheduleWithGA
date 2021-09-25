package com.solvd.scheduleWithGA.binary;

public class Teacher {
    private int id;
    private String fullName;
    private int speciality;

    /*public Teacher(int id, String fullName, Speciality speciality) {
        this.id = id;
        this.fullName = fullName;
        this.speciality = speciality.getId();
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", speciality=" + speciality +
                '}';
    }
}
