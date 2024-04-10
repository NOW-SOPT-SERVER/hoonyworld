package sopt.bank.view;

import sopt.bank.domain.Account;

public class OutputView {

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printSuccessMessage(String operation, double amount) {
        System.out.printf("%s가 성공적으로 완료되었습니다. 금액: %,d원\n", operation, (long)amount);
    }

    public static void printAccountBalance(String accountOwner, String accountNumber, double balance) {
        System.out.printf("%s님의 계좌(%s) 잔액: %,d원\n", accountOwner, accountNumber, (long)balance);
    }

    public static void printErrorMessage(String errorType) {
        System.out.println("에러: " + errorType);
    }

    public static void printTransactionConfirmation(String operation, Account sourceAccount, Account destinationAccount) {
        printMessage(operation + "이(가) 완료되었습니다.");
        if (sourceAccount != null) {
            printAccountBalance(sourceAccount.getOwner(), sourceAccount.getAccountNumber(), sourceAccount.getBalance());
        }
        if (destinationAccount != null) {
            printAccountBalance(destinationAccount.getOwner(), destinationAccount.getAccountNumber(), destinationAccount.getBalance());
        }
    }
}
