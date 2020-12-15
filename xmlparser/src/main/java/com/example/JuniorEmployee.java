package com.example;

import com.example.annot.N3;

@N3
public class JuniorEmployee extends Employee {
    private int monthOfInternship;

    public JuniorEmployee(String name, int age) {
        super(name, age);
    }

    public int getMonthOfInternship() {
        return monthOfInternship;
    }

    public void setMonthOfInternship(int monthOfInternship) {
        this.monthOfInternship = monthOfInternship;
    }
}
