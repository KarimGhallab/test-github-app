package com.mobioos.bankweb.models.cards;

public interface ICreditCard {
    double deposit(double amount);

    double withdraw(double amount);
}