package com.abc

import com.abc.InvalidTransactionAmountException
import spock.lang.Specification

import java.util.concurrent.TimeUnit

/**
 * Created by npatta01 on 11/18/15.
 */
class TransactionTestSpec extends Specification {

    Transaction transaction
    double amount = 5.50

    def setup() {
        transaction = null

    }


    def 'Deposit Transaction'() {
        when: 'transaction of type deposit'
        transaction = new Transaction(amount, TransactionType.DEPOSIT)

        then: "type should be deposit"
        assert transaction.transactionType == TransactionType.DEPOSIT

        and: "amount should be positive"
        assert amount == transaction.amount
    }


    def 'Withdrawl Transaction'() {

        when: 'transaction of type withdrawl'
        transaction = new Transaction(amount, TransactionType.WITHDRAW)

        then: 'type should be withdrawl'
        assert transaction.transactionType == TransactionType.WITHDRAW

        and: 'amount should be negative'
        assert amount == -transaction.amount

    }

    def 'Transaction with date specified'() {

        given: 'Some past timestamp'
        Date someDate = pastDate(5)

        when: 'transaction with no date specified'
        transaction = new Transaction(amount, TransactionType.WITHDRAW)

        and: 'transaction with date specified'
        Transaction datedTransaction = new Transaction(amount, TransactionType.WITHDRAW, someDate)

        then: 'dated transaction has correct date'
        assert datedTransaction.transactionDate == someDate

        and: 'non dated transaction has recent date'
        long duration = DateProvider.instance.now().getTime() - transaction.transactionDate.getTime()
        assert TimeUnit.MILLISECONDS.toHours(duration)==0

    }


    def 'Negative transaction amount throws error'() {
        when: 'Negative Transaction'
        Transaction t = new Transaction(-10d, TransactionType.DEPOSIT)

        then:
        thrown InvalidTransactionAmountException
    }


    def pastDate(int days) {
        Calendar calendar = Calendar.getInstance(); // this would default to now
        calendar.add(Calendar.DAY_OF_MONTH, -days)

        return calendar.getTime()
    }

}
