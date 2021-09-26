package com.solvd.scheduleWithGA.binary;

import java.util.Objects;

public class Speciality {
    private int idSpeciality;
    private String specialityName;

    public int getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speciality)) return false;
        Speciality that = (Speciality) o;
        return idSpeciality == that.idSpeciality && specialityName.equals(that.specialityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSpeciality, specialityName);
    }
}
