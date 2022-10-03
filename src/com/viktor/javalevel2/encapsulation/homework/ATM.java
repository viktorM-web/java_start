package com.viktor.javalevel2.encapsulation.homework;

/**
 * Создать класс, описывающий банкомат.
 * <p>
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 20, 50 и 100.
 * <p>
 * Сделать методы для добавления денег в банкомат.
 * <p>
 * Сделать метод, снимающий деньги: он принимает сумму денег,
 * а возвращает булево значение - успешность выполнения операции.
 * <p>
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * <p>
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 */
public class ATM {
    private static final int DENOMINATION_OF_TWENTY_DOLLAR_BILL = 20;
    private static final int DENOMINATION_OF_FIFTY_DOLLAR_BILL = 50;
    private static final int DENOMINATION_OF_HUNDRED_DOLLAR_BILL = 100;
    private int amountOfTwentyDollarBill;
    private int amountOfFiftyDollarBill;
    private int amountOfHundredDollarBill;
    private int amountOfMoneyInTheATM;

    ATM(int amountOfTwentyDollarBill, int amountOfFiftyDollarBill, int amountOfHundredDollarBill) {
        this.amountOfTwentyDollarBill = amountOfTwentyDollarBill;
        this.amountOfFiftyDollarBill = amountOfFiftyDollarBill;
        this.amountOfHundredDollarBill = amountOfHundredDollarBill;
        countAmountOfMoneyInTheATM();
    }

    void addCashToTheATM(int amountOfTwentyDollarBill, int amountOfFiftyDollarBill, int amountOfHundredDollarBill) {
        this.amountOfTwentyDollarBill += amountOfTwentyDollarBill;
        this.amountOfFiftyDollarBill += amountOfFiftyDollarBill;
        this.amountOfHundredDollarBill += amountOfHundredDollarBill;
        countAmountOfMoneyInTheATM();
        System.out.format("%d - 20$ bills\n%d - 50$ bills\n%d - 100$ bills\nadded to an ATM\n",
                amountOfTwentyDollarBill, amountOfFiftyDollarBill, amountOfHundredDollarBill);
    }

    boolean withdrawCash(int amountOfMoney) {
        if (amountOfMoney > amountOfMoneyInTheATM) {
            System.out.println("Insufficient funds in the ATM");
            return false;
        } else {
            int currentAmountOfMoney = 0;
            int counterAmountOfHundredDollarBill = 0;
            int counterAmountOfFiftyDollarBill = 0;
            int counterAmountOfTwentyDollarBill = 0;
            int currentAmountOfHundredDollarBill = amountOfHundredDollarBill;
            int currentAmountOfFiftyDollarBill = amountOfFiftyDollarBill;
            int currentAmountOfTwentyDollarBill = amountOfTwentyDollarBill;
            int remainder = amountOfMoney % 100;

            if (remainder % 20 == 0) {
                if (remainder / 20 <= currentAmountOfTwentyDollarBill) {
                    currentAmountOfTwentyDollarBill -= remainder / 20;
                    counterAmountOfTwentyDollarBill += remainder / 20;
                } else {
                    System.out.println("Try entering a different amount");
                    return false;
                }
            } else if (remainder % 50 % 20 == 0) {
                if (currentAmountOfFiftyDollarBill >= 1 && remainder % 50 / 20 <= currentAmountOfTwentyDollarBill) {
                    currentAmountOfFiftyDollarBill--;
                    counterAmountOfFiftyDollarBill++;
                    currentAmountOfTwentyDollarBill -= remainder % 50 / 20;
                    counterAmountOfTwentyDollarBill += remainder % 50 / 20;
                } else {
                    System.out.println("Try entering a different amount");
                    return false;
                }
            } else {
                System.out.println("Not correct amount");
                return false;
            }
            currentAmountOfMoney = amountOfMoney - remainder;
            if (currentAmountOfMoney / 100 <= currentAmountOfHundredDollarBill) {
                currentAmountOfHundredDollarBill -= currentAmountOfMoney / 100;
                counterAmountOfHundredDollarBill += currentAmountOfMoney / 100;
            } else {
                counterAmountOfHundredDollarBill = currentAmountOfHundredDollarBill;
                currentAmountOfHundredDollarBill -= counterAmountOfHundredDollarBill;
                currentAmountOfMoney -= counterAmountOfHundredDollarBill * 100;
                if (currentAmountOfMoney / 50 <= currentAmountOfFiftyDollarBill) {
                    currentAmountOfFiftyDollarBill -= currentAmountOfMoney / 50;
                    counterAmountOfFiftyDollarBill += currentAmountOfMoney / 50;
                } else {
                    int localCounterOfFiftyDollarBill =
                            currentAmountOfFiftyDollarBill % 2 == 0 ?
                                    currentAmountOfFiftyDollarBill : currentAmountOfFiftyDollarBill - 1;
                    currentAmountOfFiftyDollarBill -= localCounterOfFiftyDollarBill;
                    currentAmountOfMoney -= localCounterOfFiftyDollarBill * 50;
                    counterAmountOfFiftyDollarBill += localCounterOfFiftyDollarBill;
                    if (currentAmountOfMoney / 20 <= currentAmountOfTwentyDollarBill) {
                        currentAmountOfTwentyDollarBill -= currentAmountOfMoney / 20;
                        counterAmountOfTwentyDollarBill += currentAmountOfMoney / 20;
                    } else {
                        System.out.println("Try entering a different amount");
                        return false;
                    }
                }
            }
            this.amountOfTwentyDollarBill = currentAmountOfTwentyDollarBill;
            this.amountOfFiftyDollarBill = currentAmountOfFiftyDollarBill;
            this.amountOfHundredDollarBill = currentAmountOfHundredDollarBill;
            countAmountOfMoneyInTheATM();
            System.out.printf("%d - 20$ bills\n%d - 50$ bills\n%d - 100$ bills\nwas withdrawn from the ATM\n",
                    counterAmountOfTwentyDollarBill, counterAmountOfFiftyDollarBill, counterAmountOfHundredDollarBill);
            return true;
        }
    }

    void countAmountOfMoneyInTheATM() {
        amountOfMoneyInTheATM = this.amountOfTwentyDollarBill * DENOMINATION_OF_TWENTY_DOLLAR_BILL +
                this.amountOfFiftyDollarBill * DENOMINATION_OF_FIFTY_DOLLAR_BILL +
                this.amountOfHundredDollarBill * DENOMINATION_OF_HUNDRED_DOLLAR_BILL;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "amountOfTwentyDollarBill=" + amountOfTwentyDollarBill +
                ", amountOfFiftyDollarBill=" + amountOfFiftyDollarBill +
                ", amountOfHundredDollarBill=" + amountOfHundredDollarBill +
                ", amountOfMoneyInTheATM=" + amountOfMoneyInTheATM +
                '}';
    }
}
