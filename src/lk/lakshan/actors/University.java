package lk.lakshan.actors;

import lk.lakshan.resources.CurrentAccount;
import lk.lakshan.resources.Transaction;
import lk.lakshan.resources.Utilities;

public class University extends Thread {
    private String name;
    private CurrentAccount currentAccount;

    public University(ThreadGroup group, String name, CurrentAccount currentAccount) {
        super(group, name);
        this.name = name;
        this.currentAccount = currentAccount;
    }

    @Override
    public void run() {
        System.out.println("----- University: " + name + "'s transactions started -----");

        for (int i=0; i<3; i++) {
            Transaction semesterFee = new Transaction(this.name, 100000, "College Fee",
                    Utilities.TYPE_WITHDRAW);
            currentAccount.withdraw(semesterFee);
            System.out.println("[Transaction]: " + semesterFee);
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("----- University: " + name + "'s transactions end -----");
    }
}
