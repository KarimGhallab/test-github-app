package com.mobioos.bankweb;

import com.mobioos.bankweb.models.Account;
import com.mobioos.bankweb.models.cards.StandardCreditCard;

public abstract class AccountProvider {
    public static Account DEFAULT_ACCOUNT = new Account(1, 500, "USD", new StandardCreditCard());
}
