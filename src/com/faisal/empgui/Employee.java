package com.faisal.empgui;

public class Employee {
	public Employee(String fistName, String middleName, String lastName, String nID, String phone, String email,
			String address, String imageUrl) {
		super();
		FirstName = fistName;
		MiddleName = middleName;
		LastName = lastName;
		NID = nID;
		Phone = phone;
		Email = email;
		Address = address;
		ImageUrl = imageUrl;
	}

	public String getName() {
		StringBuilder sb = new StringBuilder(FirstName + " ");
		sb.append(MiddleName + " ");
		sb.append(LastName);
		return sb.toString();
	}

	public void setFirstName(String name) {
		FirstName = name;
	}

	public String getNID() {
		return NID;
	}

	public void setNID(String nID) {
		NID = nID;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String NID;
	private String Phone;
	private String Email;
	private String Address;
	private String ImageUrl;
}
