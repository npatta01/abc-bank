package com.abc;

/**
 * Created by npatta01 on 11/18/15.
 */
public enum AccountType {

    CHECKINGS("Checkings"), SAVINGS("Savings"), MAXI_SAVINGS("Maxi Savings");

    private String type;

    AccountType(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }
}
