package lk.lakshan.resources;

/**
 * ********************************************************************
 * File:	Statement.java	  [class]
 * Author:	P. Howells
 * Contents:	6SENG002W CWK:  Banking System
 * Provides the data structure for a bank account statement.
 * Date:	25/10/19
 * ***********************************************************************
 */


public class Statement {

    /********* private Instance Variables *********/

    private final char TAB = '\t';
    private final int MAX_TRANS = 20;

    private final StatementEntry[] statement = new StatementEntry[MAX_TRANS];

    private final String accountHolder;
    private final int accountNumber;

    private int transactionCount = 0;


    /********* public Constructor Method *********/

    public Statement(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }


    /********* public Modifier Methods *********/

    public void addTransaction(String customerName, String description, double amount, double balance, String type) {
        // Create a new statement entry & add to the statement
        statement[transactionCount] = new StatementEntry(customerName, description, amount, balance, type);
        transactionCount++;
    }


    public void print() {

        System.out.println();

        System.out.println("Statement for " + accountHolder + "'s Account: " + accountNumber);

        System.out.println(Utilities.STATEMENT_LINE);
        System.out.format("%1$-15s %2$-25s %3$15s  %4$15s", "Customer", "Description", "Amount", "Balance");
        System.out.println();
        System.out.println(Utilities.STATEMENT_LINE);

        for (int tid = 0; tid < transactionCount; tid++) {
            //	    System.out.println( statement[ tid ] ) ;
            System.out.format("%1$-15s %2$-25s %3$15s  %4$15f",
                    statement[tid].getCustomerName(),
                    statement[tid].getDescription(),
                    statement[tid].getType()+statement[tid].getAmount(),
                    statement[tid].getCurrentBalance()
            );

            System.out.println();
        }

        System.out.println(Utilities.STATEMENT_LINE);
        System.out.println();
    }

} // Statement


