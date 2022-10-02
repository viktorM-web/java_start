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
        } else if (amountOfMoney % 100 % 50 % 20 != 0 && amountOfMoney % 20 != 0) {
            System.out.println("Insufficient funds in the ATM");
            return false;
        } else {
            return withdraw(amountOfMoney);
        }
    }

    private boolean withdraw(int amountOfMoney) {
        int currentAmountOfMoney = amountOfMoney;
        int currentAmountOfTwentyDollarBill = amountOfTwentyDollarBill;
        int currentAmountOfFiftyDollarBill = amountOfFiftyDollarBill;
        int currentAmountOfHundredDollarBill = amountOfHundredDollarBill;
        int counterHundredDollarBill = 0;
        int counterFiftyDollarBill = 0;
        int counterTwentyDollarBill = 0;
        while (currentAmountOfMoney >= DENOMINATION_OF_HUNDRED_DOLLAR_BILL) {
            if (currentAmountOfHundredDollarBill != 0) {
                currentAmountOfMoney -= DENOMINATION_OF_HUNDRED_DOLLAR_BILL;
                currentAmountOfHundredDollarBill--;
                counterHundredDollarBill++;
            } else if (currentAmountOfFiftyDollarBill > 1) {
                currentAmountOfMoney -= DENOMINATION_OF_FIFTY_DOLLAR_BILL;
                currentAmountOfFiftyDollarBill--;
                counterFiftyDollarBill++;
            } else if (currentAmountOfTwentyDollarBill > 4) {
                currentAmountOfMoney -= DENOMINATION_OF_TWENTY_DOLLAR_BILL;
                currentAmountOfTwentyDollarBill--;
                counterTwentyDollarBill++;
            } else {
                System.out.println("Insufficient funds in the ATM");
                return false;
            }
        }
        switch (currentAmountOfMoney) {
            case 90:
                if (currentAmountOfFiftyDollarBill >= 1 && currentAmountOfTwentyDollarBill >= 2) {
                    counterFiftyDollarBill++;
                    currentAmountOfFiftyDollarBill--;
                    counterTwentyDollarBill += 2;
                    currentAmountOfTwentyDollarBill -= 2;
                    break;
                } else {
                    System.out.println("Insufficient funds in the ATM.\nTry entering a different amount");
                    return false;
                }
            case 80:
                if (currentAmountOfTwentyDollarBill >= 4) {
                    counterTwentyDollarBill += 4;
                    currentAmountOfTwentyDollarBill -= 4;
                    break;
                } else {
                    System.out.println("Insufficient funds in the ATM.\nTry entering a different amount");
                    return false;
                }
            case 70:
                if (currentAmountOfFiftyDollarBill >= 1 && currentAmountOfTwentyDollarBill >= 1) {
                    counterFiftyDollarBill++;
                    currentAmountOfFiftyDollarBill--;
                    counterTwentyDollarBill++;
                    currentAmountOfTwentyDollarBill--;
                    break;
                } else {
                    System.out.println("Insufficient funds in the ATM.\nTry entering a different amount");
                    return false;
                }
            case 60:
                if (currentAmountOfTwentyDollarBill >= 3) {
                    counterTwentyDollarBill += 3;
                    currentAmountOfTwentyDollarBill -= 3;
                    break;
                } else {
                    System.out.println("Insufficient funds in the ATM.\nTry entering a different amount");
                    return false;
                }
            case 50:
                if (currentAmountOfFiftyDollarBill >= 1) {
                    counterFiftyDollarBill++;
                    currentAmountOfFiftyDollarBill--;
                    break;
                } else {
                    System.out.println("Insufficient funds in the ATM.\nTry entering a different amount");
                    return false;
                }
            case 40:
                if (currentAmountOfTwentyDollarBill >= 2) {
                    counterTwentyDollarBill += 2;
                    currentAmountOfTwentyDollarBill -= 2;
                    break;
                } else {
                    System.out.println("Insufficient funds in the ATM.\nTry entering a different amount");
                    return false;
                }
            case 20:
                if (currentAmountOfTwentyDollarBill >= 1) {
                    counterTwentyDollarBill++;
                    currentAmountOfTwentyDollarBill--;
                    break;
                } else {
                    System.out.println("Insufficient funds in the ATM.\nTry entering a different amount");
                    return false;
                }
            default:
                return false;
        }
        this.amountOfTwentyDollarBill = currentAmountOfTwentyDollarBill;
        this.amountOfFiftyDollarBill = currentAmountOfFiftyDollarBill;
        this.amountOfHundredDollarBill = currentAmountOfHundredDollarBill;
        countAmountOfMoneyInTheATM();
        System.out.printf("%d - 20$ bills\n%d - 50$ bills\n%d - 100$ bills\nwas withdrawn from the ATM\n",
                counterTwentyDollarBill, counterFiftyDollarBill, counterHundredDollarBill);
        return true;
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
