package lk.lakshan.resources;

/**
 * ********************************************************************
 * File:	Transaction.java    [class]
 * Author:	P. Howells
 * Contents:	6SENG002W CWK: Banking System
 * Provides the basic data structure for a bank transaction. That
 * is customer id & the amount to either deposit or withdraw
 * Date:	25/10/19
 * ***********************************************************************
 */

public class Transaction {
    private final String customerName;
    private final double amount;
    private final String description;
    private final String type;

    public Transaction(String customerName, double amount, String description, String type) {
        this.customerName = customerName;
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return new String("[ " + "Customer: " + customerName + ", "
                + "Amount: " + amount + ", Description: " + description + "]"
        );
    }

} // Transaction

