package com.viktor.javalevel2.beginningoop.homework;

public class Floor {
    private int numberFloor;
    private Flat[] planFloor;

    public Floor(int numberFloor, Flat[] planFloor) {
        this.numberFloor = numberFloor;
        this.planFloor = planFloor;
    }

    public void print() {
        System.out.println("Floor number " + numberFloor + ", numbers of flat " + planFloor.length);
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    public Flat[] getPlanFloor() {
        return planFloor;
    }

    public void setPlanFloor(Flat[] planFloor) {
        this.planFloor = planFloor;
    }
}
