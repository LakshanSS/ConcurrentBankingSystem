package lk.lakshan.actors;

import lk.lakshan.resources.CurrentAccount;
import lk.lakshan.resources.Transaction;
import lk.lakshan.resources.Utilities;

public class Grandmother extends Thread{
    private String name;
    private CurrentAccount currentAccount;

    public Grandmother(ThreadGroup group, String name, CurrentAccount currentAccount) {
        super(group, name);
        this.name = name;
        this.currentAccount = currentAccount;
    }

    @Override
    public void run() {
        System.out.println("----- Grandmother: " + name + "'s transactions started -----");

        Transaction birthdayPresent = new Transaction(this.name, 20000, "birthday Present",
                Utilities.TYPE_DEPOSIT);
        currentAccount.deposit(birthdayPresent);
        System.out.println("[Transaction]: " + birthdayPresent);
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Transaction christmasPresent = new Transaction(this.name, 30000, "christmas Present",
                Utilities.TYPE_DEPOSIT);
        currentAccount.deposit(christmasPresent);
        System.out.println("[Transaction]: " + christmasPresent);

        System.out.println("----- Grandmother: " + name + "'s transactions end -----");
    }
}
