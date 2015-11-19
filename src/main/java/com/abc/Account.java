package com.abc;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private List<Transaction> transactions;


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Account() {

        this.transactions = new ArrayList<>();
    }


    private void addNewTransaction(TransactionType transactionType, double amount) {
        Transaction t = new Transaction(amount, transactionType);
        this.transactions.add(t);
    }


    public abstract double interestEarned();

    public double sumTransactions() {
        double amount = 0.0;
        for (Transaction t : transactions)
            amount += t.getAmount();
        return amount;
    }

    public abstract AccountType getAccountType();


    public void deposit(double amount) {
        addNewTransaction(TransactionType.DEPOSIT, amount);
    }

    public void withdraw(double amount) {
        addNewTransaction(TransactionType.WITHDRAW, amount);

    }
}
