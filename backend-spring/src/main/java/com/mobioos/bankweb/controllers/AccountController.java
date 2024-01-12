package com.mobioos.bankweb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobioos.bankweb.AccountProvider;
import com.mobioos.bankweb.models.Account;
import com.mobioos.bankweb.models.OperationMessage;
import com.mobioos.bankweb.models.cards.CashBackCreditCard;
import com.mobioos.bankweb.models.cards.DeferredCreditCard;
import com.mobioos.bankweb.models.cards.StandardCreditCard;

@RestController
@RequestMapping("/api/account/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {
  private Account _defaultAccount = AccountProvider.DEFAULT_ACCOUNT;

  private Logger _logger = LoggerFactory.getLogger(AccountController.class);

  @GetMapping("/")
  public Account getAccount() {
    this._logger.info("Getting the default account");
    return this._defaultAccount;
  }

  @GetMapping("/deposit")
  public OperationMessage deposit(double amount) {
    this._logger.info("Deposing " + amount);
    return this._defaultAccount.deposit(amount);
  }

  @GetMapping("/withdraw")
  public OperationMessage withdraw(double amount) {
    this._logger.info("Withdrawing " + amount);
    return this._defaultAccount.withdraw(amount);
  }

  @GetMapping("/setCard")
  public OperationMessage setCard(String cardId) {
    this._logger.info("Setting card with ID " + cardId);

    switch (cardId) {
      case "standard":
        this._defaultAccount.setCreditCard(new StandardCreditCard());
        return OperationMessage.createOkMessage(this._defaultAccount.getBalance());
      case "cashback":
        this._defaultAccount.setCreditCard(new CashBackCreditCard());
        return OperationMessage.createOkMessage(this._defaultAccount.getBalance());
      case "deferred":
        this._defaultAccount.setCreditCard(new DeferredCreditCard());
        return OperationMessage.createOkMessage(this._defaultAccount.getBalance());
      default:
        return OperationMessage.createKoMessage("Could not set new card", "Unknown card id \"" + cardId + "\"",
            this._defaultAccount.getBalance());
    }
  }
}