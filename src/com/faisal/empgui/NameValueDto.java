package com.faisal.empgui;

public class NameValueDto<T> {
	@Override
	public String toString() {
		return  getName();
	}

	public NameValueDto(String name, T value) {
		super();
		Name = name;
		Value = value;
	}

	private String Name;
	private T Value;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public T getValue() {
		return Value;
	}

	public void setValue(T value) {
		Value = value;
	}
}