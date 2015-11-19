package com.abc

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by npatta01 on 11/18/15.
 */
class TransactionTypeSpec extends Specification {


    @Unroll('Transaction type has correct #type_description')
    def 'Transaction type has correct #description'() {

        when:
        String actual_description = transaction_type.description
        then:
        assert actual_description == type_description

        where:
        transaction_type             | type_description
        TransactionType.DEPOSIT  | "deposit"
        TransactionType.WITHDRAW | "withdraw"

    }


    def 'There are 2 transaction types'() {
        expect:
        assert TransactionType.values().length == 2
    }

}
