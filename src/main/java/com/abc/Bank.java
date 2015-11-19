package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.summingDouble;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Summary");
        for (Customer c : customers) {
            sb.append("\n - ");
            sb.append(String.format("%s (%s)", c.getName(), format(c.getNumberOfAccounts(), "account")));


        }
        return sb.toString();
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return String.format("%d %s", number, number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        double total = customers
                .stream()
                .map(Customer::totalInterestEarned)
                .collect(summingDouble(Double::doubleValue));

        return total;
    }


}
