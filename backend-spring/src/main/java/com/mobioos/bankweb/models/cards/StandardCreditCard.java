package com.mobioos.bankweb.models.cards;

import java.beans.JavaBean;

@JavaBean
public class StandardCreditCard implements ICreditCard {
    public double deposit(double amount) {
        return amount;
    }

    public double withdraw(double amount) {
        return amount;
    }
}