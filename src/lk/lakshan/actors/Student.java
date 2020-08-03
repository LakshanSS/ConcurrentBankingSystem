package lk.lakshan.actors;

import lk.lakshan.resources.CurrentAccount;
import lk.lakshan.resources.Transaction;
import lk.lakshan.resources.Utilities;

public class Student extends Thread {
    private String name;
    private CurrentAccount currentAccount;

    public Student(ThreadGroup group, String name, CurrentAccount currentAccount) {
        super(group, name);
        this.name = name;
        this.currentAccount = currentAccount;
    }

    @Override
    public void run() {
        System.out.println("----- Student: " + name + "'s transactions started -----");

        Transaction buyPhone = new Transaction(this.name, 50000, "buy Phone",
                Utilities.TYPE_WITHDRAW);
        currentAccount.withdraw(buyPhone);
        System.out.println("[Transaction]: " + buyPhone);
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Transaction winLottery = new Transaction(this.name, 200000, "win Lottery",
                Utilities.TYPE_DEPOSIT);
        currentAccount.deposit(winLottery);
        System.out.println("[Transaction]: " + winLottery);
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Transaction buyLunch = new Transaction(this.name, 500, "buy Lunch", Utilities.TYPE_WITHDRAW);
        currentAccount.withdraw(buyLunch);
        System.out.println("[Transaction]: " + buyLunch);
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Transaction buyMovieTicket = new Transaction(this.name, 800, "buy Movie Ticket",
                Utilities.TYPE_WITHDRAW);
        currentAccount.withdraw(buyMovieTicket);
        System.out.println("[Transaction]: " + buyMovieTicket);
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Transaction internshipSalary = new Transaction(this.name, 20000, "internship Salary",
                Utilities.TYPE_DEPOSIT);
        currentAccount.deposit(internshipSalary);
        System.out.println("[Transaction]: " + internshipSalary);
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Transaction payPhoneBill = new Transaction(this.name, 1000, "pay phone bill",
                Utilities.TYPE_WITHDRAW);
        currentAccount.withdraw(payPhoneBill);
        System.out.println("[Transaction]: " + payPhoneBill);
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----- Student: " + name + "'s transactions end -----");
    }
}
