package com.viktor.javaLevel2.beginningOOP.homework;

public class Room {
    private boolean isPassage;

    Room(boolean isPassage) {
        this.isPassage = isPassage;
    }

    public void print() {
        if (isPassage) {
            System.out.println("Passage room");
        } else System.out.println("Not Passage room");
    }
}
