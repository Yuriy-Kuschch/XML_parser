package com.example;

import com.example.annot.N4;

@N4
public class MiddleEmployee extends Employee {
    private int monthBeforePlus500;

    public MiddleEmployee(String name, int age) {
        super(name, age);
    }

    public int getMonthBeforePlus500() {
        return monthBeforePlus500;
    }

    public void setMonthBeforePlus500(int monthBeforePlus500) {
        this.monthBeforePlus500 = monthBeforePlus500;
    }
}
