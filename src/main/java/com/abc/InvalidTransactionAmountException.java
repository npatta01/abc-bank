package com.abc;


/**
 * Created by npatta01 on 11/18/15.
 */
public class InvalidTransactionAmountException extends IllegalArgumentException {

    public InvalidTransactionAmountException(double amount) {
        super(String.format("Transaction Amount %s is invalid. Transactions must be positive", amount));
    }


}
