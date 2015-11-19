package com.abc

import spock.lang.Specification

import static java.lang.Math.abs

/**
 * Created by npatta01 on 11/18/15.
 */
class CustomerSpec extends Specification {

    String customerName = 'Oscar'

    def 'New Customer'() {
        when:
        Customer c = new Customer(customerName)

        then: 'correct name'
        assert c.name == customerName

        and: '0 accounts'
        assert c.numberOfAccounts == 0

        and: 'empty statement'
        assert c.statement ==
                """Statement for Oscar

Total In All Accounts \$0.00"""

        and: '0 interest'
        assert c.totalInterestEarned() == 0

    }

    def 'Opening Multiple Accounts'() {
        when: 'One Account'
        Customer c = new Customer(customerName)
        c.openAccount(new SavingsAccount())
        assert c.numberOfAccounts == 1

        then: 'adding a new  account'
        c.openAccount(new CheckingsAccount())
        assert c.numberOfAccounts == 2

        and: 'adding third  account'
        c.openAccount(new MaxiSavingsAccount())
        assert c.numberOfAccounts == 3
    }


    def 'Statement Generation'() {
        given:
        Account checkingAccount = new CheckingsAccount();
        Account savingsAccount = new SavingsAccount();

        Customer c = new Customer(customerName).openAccount(checkingAccount).openAccount(savingsAccount);

        double amount1 = 100d;
        double amount2 = 4000;
        double amount3 = 200;


        String amount1Str = toDollars(amount1)
        String amount2Str = toDollars(amount2)
        String amount3Str = toDollars(amount3)

        String amount4Str = toDollars(amount2 - amount3)

        String amount5Str = toDollars(amount1 + amount2 - amount3)

        when: 'transactions'
        checkingAccount.deposit(amount1)
        savingsAccount.deposit(amount2)
        savingsAccount.withdraw(amount3)

        then:
        assert c.statement == """Statement for $customerName

Checkings Account
   deposit $amount1Str
   Total $amount1Str

Savings Account
   deposit $amount2Str
   withdrawal $amount3Str
   Total $amount4Str

Total In All Accounts $amount5Str"""
    }

    private static String toDollars(double d) {
        return String.format('$%,.2f', abs(d));
    }
}
