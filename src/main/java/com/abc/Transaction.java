package com.abc;

import java.util.Date;

public class Transaction {
    private final double amount;

    private Date transactionDate;

    private TransactionType transactionType;

    public Transaction(double amount, TransactionType transactionType, Date date) {
        this.transactionType = transactionType;

        if (amount < 0) {
            throw new InvalidTransactionAmountException(amount);
        }

        if (transactionType == TransactionType.WITHDRAW) {
            this.amount = -amount;
        } else {
            this.amount = amount;
        }
        this.transactionDate = date;
    }

    public Transaction(double amount, TransactionType transactionType) {

        this(amount, transactionType, DateProvider.getInstance().now());

    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }


    public double getAmount() {
        return amount;
    }
}
