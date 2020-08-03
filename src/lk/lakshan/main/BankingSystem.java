package lk.lakshan.main;

import lk.lakshan.actors.Grandmother;
import lk.lakshan.actors.LoanCompany;
import lk.lakshan.actors.Student;
import lk.lakshan.actors.University;
import lk.lakshan.resources.CurrentAccount;
import lk.lakshan.resources.Utilities;

public class BankingSystem {

    private static final double INITIAL_BALANCE = 100;

    public static void main(String[] args) {
        CurrentAccount studentAccount = new CurrentAccount(123, INITIAL_BALANCE, "Lakshan");
        studentAccount.getStatement().addTransaction("-------", "Initial Balance",
                INITIAL_BALANCE, INITIAL_BALANCE, Utilities.TYPE_DEPOSIT);

        ThreadGroup humans = new ThreadGroup("Humans");
        ThreadGroup organizations = new ThreadGroup("Organizations");

        Student student = new Student(humans, studentAccount.getAccountHolder(), studentAccount);
        LoanCompany loanCompany = new LoanCompany(organizations, "ABC Finance", studentAccount);
        Grandmother grandmother = new Grandmother(humans, "Helen", studentAccount);
        University university = new University(organizations, "UOW", studentAccount);

        student.start();
        grandmother.start();
        loanCompany.start();
        university.start();

        try {
            student.join();
            grandmother.join();
            loanCompany.join();
            university.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        studentAccount.printStatement();
    }
}
