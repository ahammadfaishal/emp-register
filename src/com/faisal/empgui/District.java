package com.faisal.empgui;

public class District {
    private String Division;
    private String District;
    private int Id;

    public District(String division, String district) {
        this.Division = division;
        this.District = district;
    }

    public District(int id, int division_Id, String district) {
        this.Id = id;
        Divisions enumValue = Divisions.values()[division_Id];
        this.Division = enumValue.name();
        this.District = district;
    }

    @Override
    public String toString() {
        return getDistrict();
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getId() {
        return Id;
    }
}
