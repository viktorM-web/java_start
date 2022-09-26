package com.viktor.javaLevel2.beginningOOP.homework;

public class Flat {
    private int numberFlat;
    private Room[] planFlat;

    public Flat(int numberFlat, Room[] planFlat) {
        this.numberFlat = numberFlat;
        this.planFlat = planFlat;
    }

    public void print() {
        System.out.println("Flat number " + numberFlat + ", numbers of rooms " + planFlat.length);
    }

    public int getNumberFlat() {
        return numberFlat;
    }

    public void setNumberFlat(int numberFlat) {
        this.numberFlat = numberFlat;
    }

    public Room[] getPlanFlat() {
        return planFlat;
    }

    public void setPlanFlat(Room[] planFlat) {
        this.planFlat = planFlat;
    }
}
