package com.abc;

/**
 * Created by npatta01 on 11/18/15.
 */
public enum TransactionType {
    DEPOSIT("deposit"),
    WITHDRAW("withdraw");

    private String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return type;
    }
}