package com.faisal.empgui;

public class NameValueDto<T> {
    private String Name;
    private T Value;

    public NameValueDto(String name, T value) {
        super();
        Name = name;
        Value = value;
    }

    @Override
    public String toString() {
        return getName();
    }

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