package com.mobioos.bankweb.models.cards;

public class CashBackCreditCard implements ICreditCard {
    public double deposit(double amount) {
        return amount + (amount * 0.01);
    }

    public double withdraw(double amount) {
        return amount;
    }
}