package lk.lakshan.actors;

import lk.lakshan.resources.CurrentAccount;
import lk.lakshan.resources.Transaction;
import lk.lakshan.resources.Utilities;

public class LoanCompany extends Thread{
    private String name;
    private CurrentAccount currentAccount;

    public LoanCompany(ThreadGroup group, String name, CurrentAccount currentAccount) {
        super(group, name);
        this.name = name;
        this.currentAccount = currentAccount;
    }

    @Override
    public void run() {
        System.out.println("----- Loan Company: " + name + "'s transactions started -----");

        for (int i=0; i<3; i++) {
            Transaction addLoan = new Transaction(this.name, 40000, "loan", Utilities.TYPE_DEPOSIT);
            currentAccount.deposit(addLoan);
            System.out.println("[Transaction]: " + addLoan);
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("----- Loan Company: " + name + "'s transactions end -----");
    }
}
