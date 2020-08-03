package lk.lakshan.resources;

/**
 * ********************************************************************
 * File:	BankAccount.java  [interface]
 * Author:	P. Howells
 * Contents:	6SENG002W CWK:  Banking System
 * This provides the interface for a Bank Account class.
 * Date:	25/10/19
 * ***********************************************************************
 */

public interface BankAccount {
    double getBalance();              // returns the current balance

    int getAccountNumber();        // returns the Account number

    String getAccountHolder();        // returns the Account holder

    void deposit(Transaction t);     // perform a deposit transaction on the bank account

    void withdraw(Transaction t);  // perform a withdrawal transaction on the bank account

    boolean isOverdrawn(double withdrawAmount); // returns true if overdrawn; false otherwise

    void printStatement();            // prints out the transactions performed so far

}  // BankAccount
