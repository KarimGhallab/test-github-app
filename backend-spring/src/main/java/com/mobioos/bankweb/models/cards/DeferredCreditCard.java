package com.mobioos.bankweb.models.cards;

import java.beans.JavaBean;

@JavaBean
public class DeferredCreditCard implements ICreditCard {

    private int withdrawCpt;
    private double deferredWithdraw;

    public DeferredCreditCard() {
        this.withdrawCpt = 0;
        this.deferredWithdraw = 0;
    }

    public double deposit(double amount) {
        return amount;
    }

    public double withdraw(double amount) {
        this.withdrawCpt++;
        // We perform the withdraw every two calls
        if (withdrawCpt % 2 == 0) {
            var toWithdraw = this.deferredWithdraw + amount;
            this.deferredWithdraw = 0;
            return toWithdraw;
        } else {
            this.deferredWithdraw += amount;
            return 0;
        }
    }
}