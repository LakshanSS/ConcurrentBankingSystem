package lk.lakshan.resources;

public class CurrentAccount implements BankAccount {
    private int accountNumber;

    public Statement getStatement() {
        return statement;
    }

    private double balance;
    private String accountHolder;
    private Statement statement;

    public CurrentAccount(int accountNumber, double balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.statement = new Statement(accountHolder, accountNumber);
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String getAccountHolder() {
        return this.accountHolder;
    }

    @Override
    public synchronized void deposit(Transaction t) {
        double depositAmount = t.getAmount();
        this.balance += depositAmount;
        this.statement.addTransaction(t.getCustomerName(), t.getDescription(), depositAmount, this.balance,
                t.getType());
        notifyAll();
    }

    @Override
    public synchronized void withdraw(Transaction t) {
        double withdrawalAmount = t.getAmount();

        while (isOverdrawn(withdrawalAmount)) { // The guarded action
            try {

                System.out.println("\n---WAITING--- " + t.getCustomerName() + "'s withdrawal " + t.getDescription() +
                        " " + t.getAmount() + " is in waiting due to insufficient Balance! \nCurrent Balance: " +
                        this.balance);
                wait(); // Insufficient balance. Wait until enough balance is there.

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.balance -= withdrawalAmount;
        this.statement.addTransaction(t.getCustomerName(), t.getDescription(), withdrawalAmount, this.balance,
                t.getType());
        notifyAll();
    }

    @Override
    public boolean isOverdrawn(double withdrawAmount) {
        if (this.balance > withdrawAmount) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void printStatement() {
        this.statement.print();
    }
}
