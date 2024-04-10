package sopt.bank.view.dto;

public class WithdrawDTO {
    private String accountNumber;
    private double amount;

    public WithdrawDTO(String accountNumber, double amount) {
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
