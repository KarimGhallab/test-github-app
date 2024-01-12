package com.mobioos.bankweb.models;

import com.mobioos.bankweb.models.cards.ICreditCard;

public class Account {
  private long id;
  private double balance;
  private String currency;
  private ICreditCard creditCard;
  private boolean allowOverdraft = true;

  public Account(long id, double initial, String currency, ICreditCard creditCard) {
    this.id = id;
    this.balance = initial;
    this.currency = currency;
    this.creditCard = creditCard;
  }

  public long getId() {
    return id;
  }

  public double getBalance() {
    return balance;
  }

  public String getCurrency() {
    return currency;
  }

  public ICreditCard getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(ICreditCard creditCard) {
    this.creditCard = creditCard;
  }

  public OperationMessage deposit(double amount) {
    this.balance += this.creditCard.deposit(amount);
    return this.createBalanceOkMessage();
  }

  public OperationMessage withdraw(double amount) {
    var toWithdraw = this.creditCard.withdraw(amount);
    var sum = this.balance - toWithdraw;
    var message = this.createOverdraftKoMessage();
    if (sum >= 0) {
      this.balance -= toWithdraw;
      message = this.createBalanceOkMessage();
    }
    if (sum < 0 && allowOverdraft) {
      this.balance -= toWithdraw;
      message = this.createBalanceOkMessage();
    }
    return message;
  }

  private OperationMessage createBalanceOkMessage() {
    return OperationMessage.createOkMessage(this.balance);
  }

  private OperationMessage createOverdraftKoMessage() {
    return OperationMessage.createKoMessage("Unauthorized overdraft",
        "You cannot perform this withdraw operation because you do not have enough fund", this.balance);
  }
}