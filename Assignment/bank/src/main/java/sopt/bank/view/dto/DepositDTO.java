package sopt.bank.view.dto;

public class DepositDTO {
    private String accountNumber;
    private double amount;

    public DepositDTO(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}

