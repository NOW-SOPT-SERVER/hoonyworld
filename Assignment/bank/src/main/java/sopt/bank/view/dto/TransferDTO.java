package sopt.bank.view.dto;

public record TransferDTO(
        String sourceAccountNumber,
        String destinationAccountNumber,
        double amount
) {
}
