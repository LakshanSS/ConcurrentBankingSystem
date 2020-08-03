package lk.lakshan.resources;

/**
 * ********************************************************************
 * File:	StatementEntry.java   [class]
 * Author:	P. Howells
 * Contents:	6SENG002W CWK:  Banking System
 * This provides the basic data structure for a single
 * bank account statement entry.
 * Date:	25/10/19
 * ***********************************************************************
 */


public class StatementEntry {
    private final String customerName;
    String description;
    private final double amount;
    private final double currentBalance;
    private final String type;

    public StatementEntry(String customerName, String description, double amount, double currentBalance, String type) {
        this.customerName = customerName;
        this.description = description;
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

} // StatementEntry 

