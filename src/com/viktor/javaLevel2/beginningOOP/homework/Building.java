package com.viktor.javaLevel2.beginningOOP.homework;

public class Building {
    private int number;
    private Floor[] numberOfStoreys;

    public Building(int number, Floor[] numberOfStoreys) {
        this.number = number;
        this.numberOfStoreys = numberOfStoreys;
    }

    public void print() {
        System.out.println("Building number " + number + ", numbers of floor " + numberOfStoreys.length);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Floor[] getNumberOfStoreys() {
        return numberOfStoreys;
    }

    public void setNumberOfStoreys(Floor[] numberOfStoreys) {
        this.numberOfStoreys = numberOfStoreys;
    }
}
