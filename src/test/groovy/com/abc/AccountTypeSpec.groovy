package com.abc

import com.abc.AccountType
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by npatta01 on 11/18/15.
 */
class AccountTypeSpec extends Specification {


    @Unroll('Account type has correct #type_description')
    def 'Account type has correct #description'() {

        when:
        String actual_description = account_type.type
        then:
        assert actual_description == type_description

        where:
        account_type             | type_description
        AccountType.CHECKINGS    | "Checkings"
        AccountType.SAVINGS      | "Savings"
        AccountType.MAXI_SAVINGS | "Maxi Savings"

    }


    def 'There are 3 account types'() {
        expect:
        assert AccountType.values().length == 3
    }

}
