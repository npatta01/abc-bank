package com.abc

import spock.lang.Specification

/**
 * Created by npatta01 on 11/19/15.
 */
class BankSpec extends Specification {


    Bank bank
    Customer customer
    String customerName
    Account account

    def setup() {
        bank = new Bank()
        customerName = 'Jon'
        customer = new Customer(customerName)

    }


    def 'checking account'() {

        given:
        account = new CheckingsAccount()

        and:
        customer.openAccount(account)

        when:
        bank.addCustomer(customer);

        and:
        account.deposit(100.0);

        then:
        assert 0.1d == bank.totalInterestPaid()
    }

    def 'saving account'() {

        given:
        account = new SavingsAccount()

        and:
        customer.openAccount(account)

        when:
        bank.addCustomer(customer);

        and:
        account.deposit(1500.0);

        then:
        assert 2d == bank.totalInterestPaid()
    }


    def 'maxi saving account'() {

        given:
        account = new MaxiSavingsAccount()

        and:
        customer.openAccount(account)

        when:
        bank.addCustomer(customer);

        and:
        account.deposit(3000.0);

        then:
        assert 170d == bank.totalInterestPaid()
    }

    def 'customer summary'(){
        given:
        account = new CheckingsAccount()
        customer.openAccount(account)
        int numberofAccount= 1

        when:
        bank.addCustomer(customer);
        account.deposit(3000.0);
        String actualCustomerSummary=bank.customerSummary()
        String expectedCustomerSummary=
                """Customer Summary\n - $customerName ($numberofAccount account)"""

        then:
        assert actualCustomerSummary == expectedCustomerSummary
    }

}
