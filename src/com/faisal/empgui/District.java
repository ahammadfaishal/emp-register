package com.faisal.empgui;

public class District {
	public District(String division, String district) {
		this.Division = division;
		this.District = district;
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

	private String Division;
	private String District;
}
