package com.abc;

/**
 * Created by npatta01 on 11/18/15.
 */
public class CheckingsAccount extends Account {

    private final double interestRate = 0.001;



    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKINGS;
    }

    @Override
    public double interestEarned() {
        return sumTransactions() * interestRate;
    }
}
