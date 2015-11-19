package com.abc;

/**
 * Created by npatta01 on 11/18/15.
 */
public class SavingsAccount extends Account {

    private final double initialInterestRate = 0.001;
    private final double laterInterestRate = 0.002;
    private final double firstCutoffAmount =1000;


    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

    @Override
    public double interestEarned() {
        double amount=  sumTransactions();
        if (amount <= firstCutoffAmount)
            return amount *initialInterestRate;
        else
            return initialInterestRate* firstCutoffAmount + (amount - firstCutoffAmount) * laterInterestRate;


    }
}
