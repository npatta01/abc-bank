package com.abc;

/**
 * Created by npatta01 on 11/18/15.
 */
public class MaxiSavingsAccount extends Account {

    private final double firstInterestRate = 0.02;
    private final double secondInterestRate = 0.05;
    private final double thirdInterestRate = 0.10;

    private final double firstCutoffAmount = 1000;
    private final double secondCutoffAmount = 1000;




    @Override
    public AccountType getAccountType() {
        return AccountType.MAXI_SAVINGS;
    }

    @Override
    public double interestEarned() {
        double amount = sumTransactions();
        if (amount <= firstCutoffAmount) {
            return amount * firstInterestRate;
        } else if (amount <= firstCutoffAmount + secondCutoffAmount) {
            return firstCutoffAmount * firstInterestRate +
                    (amount - firstCutoffAmount) * secondInterestRate;
        } else {
            return firstCutoffAmount * firstInterestRate +
                    secondCutoffAmount * secondInterestRate +
                    (amount - firstCutoffAmount - secondCutoffAmount)
                            * thirdInterestRate;
        }


    }
}
