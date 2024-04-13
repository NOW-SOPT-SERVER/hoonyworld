package sopt.bank.domain;

public class Transaction {
    private double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public boolean process(Account sourceAccount, Account destinationAccount) {
        try {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
