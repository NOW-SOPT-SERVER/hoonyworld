package sopt.bank.view.dto;

public class TransferDTO {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private double amount;

    public TransferDTO(String sourceAccountNumber, String destinationAccountNumber, double amount) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public double getAmount() {
        return amount;
    }
}
