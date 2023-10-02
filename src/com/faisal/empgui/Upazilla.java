package com.faisal.empgui;

public class Upazilla {
    private String Division;
    private String District;
    private String UpazillaName;

    public Upazilla(int division_Id, String district, String upazillaName) {
        super();
        Divisions enumValue = Divisions.values()[division_Id];
        this.Division = enumValue.name();
        this.District = district;
        this.UpazillaName = upazillaName;
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

    public String getUpazillaName() {
        return UpazillaName;
    }

    public void setUpazillaName(String upazillaName) {
        UpazillaName = upazillaName;
    }
}
