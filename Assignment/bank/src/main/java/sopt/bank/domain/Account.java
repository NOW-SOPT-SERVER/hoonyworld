package sopt.bank.domain;

import sopt.bank.view.viewConstant.IllegalArgumentExceptionType;

public class Account {
    private String accountNumber;
    private String owner;
    private double balance;

    public Account(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw IllegalArgumentExceptionType.INSUFFICIENT_BALANCE.getException();
        } // 추후 컨트롤러에서 try-catch로 예외처리

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
