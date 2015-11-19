package com.abc

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by npatta01 on 11/18/15.
 */
class AccountSpec extends Specification {


    double amount = 10
    double amount2 = 5

    @Unroll('#type_description has correct state deposit and withdraw')
    def '#type_description has correct state deposit and withdraw'() {

        given:
        Account account = accountInstance
        assert account.transactions.size() == 0

        when: 'withdraw and deposit'
        account.deposit(amount)
        account.withdraw(amount2)

        then: 'has correct amount of transactions'
        assert account.transactions.size() == 2

        and: 'has correct transaction details'
        List<Transaction> actualTransactions = account.transactions
        //get actual transaction amounts
        List<Double> actualTransactionsAmounts = actualTransactions.collect({ it.amount })
        //get actual transaction types
        List<TransactionType> actualTransactionsTypes = actualTransactions.collect({ it.transactionType })

        List<Double> expectedTransactionsAmounts = [10d, -5d]
        List<TransactionType> expectedTransactionsTypes = [TransactionType.DEPOSIT, TransactionType.WITHDRAW]

        assert actualTransactionsAmounts == expectedTransactionsAmounts

        assert actualTransactionsTypes == expectedTransactionsTypes

        and: 'has correct amount'
        assert account.sumTransactions() == 5d


        where:
        accountInstance          | type_description | account_type
        new CheckingsAccount()   | 'Checkings'      | AccountType.CHECKINGS
        new SavingsAccount()     | 'Savings'        | AccountType.SAVINGS
        new MaxiSavingsAccount() | 'Maxi Savings'   | AccountType.MAXI_SAVINGS

    }

    @Unroll('Checking account has interest #interest for amount #amount')
    def 'Checking account has interest #interest for amount #amount'() {


        given:
        Account account = new CheckingsAccount()

        when:
        account.deposit(amount)

        then:
        assert account.interestEarned() == interest


        where:
        amount | interest
        500    | 0.5d
        1000  | 1d
        10000  | 10d


    }


    @Unroll('Savings account has interest #interest for amount #amount')
    def 'Savings account has interest #interest for amount #amount'() {


        given:
        Account account = new SavingsAccount()

        when:
        account.deposit(amount)

        then:
        assert account.interestEarned() == interest

        where:
        amount | interest
        500    | 0.5d
        1000  | 1d
        10000  | 19d


    }

    @Unroll('MaxiSavings account has interest #interest for amount #amount')
    def 'MaxiSavings account has interest #interest for amount #amount'() {


        given:
        Account account = new MaxiSavingsAccount()

        when:
        account.deposit(amount)

        then:
        assert account.interestEarned() == interest

        where:
        amount | interest
        500    | 10d
        1000   | 20d
        1500   | 45d
        2000   | 70d


    }

}
