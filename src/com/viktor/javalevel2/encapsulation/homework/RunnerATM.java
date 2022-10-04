package com.viktor.javalevel2.encapsulation.homework;

public class RunnerATM {
    public static void main(String[] args) {
        ATM atm = new ATM(5, 5, 5);
        System.out.println(atm.toString());
        atm.addCashToTheATM(1, 3, 6);
        System.out.println(atm.toString());
        atm.withdrawCash(180);
        System.out.println(atm.toString());
    }

}
