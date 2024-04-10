package sopt.bank.view;

import sopt.bank.view.dto.DepositDTO;
import sopt.bank.view.dto.TransferDTO;
import sopt.bank.view.dto.WithdrawDTO;
import sopt.bank.view.viewConstant.IllegalArgumentExceptionType;

import java.util.Scanner;

public class InputView {
    private static final Scanner kb = new Scanner(System.in);

    private InputView() {
    }

    // 메뉴를 받고, 1~3 숫자 검증
    public static int readMenu() {
        System.out.println("--- 메뉴를 선택하세요 ---");
        System.out.println("1. 계좌이체");
        System.out.println("2. 입금");
        System.out.println("3. 출금");

        try {
            int menu = kb.nextInt();

            if(menu < 1 || menu > 3) {
                throw IllegalArgumentExceptionType.INVALID_MENU.getException();
            }
            return menu;
        } catch (IllegalArgumentException e) {
            System.out.println(IllegalArgumentExceptionType.INVALID_MENU.getMessage());
            return readMenu();
        }
    }

    // 계좌번호를 받고 검증 메서드 호출
    public static String readAccountNumber() {
        try {
            String accountNumber = kb.next();
            validateAccountNumber(accountNumber);
            return accountNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(IllegalArgumentExceptionType.INVALID_ACCOUNT_NUMBER.getMessage());
            return readAccountNumber();
        }
    }

    // 계좌번호 숫자인지 검증, 계좌번호 길이 검증(14자리)
    public static void validateAccountNumber(String accountNumber) {
        String[] temporary = accountNumber.split("-");
        int totalLength = 0;
        for (String part : temporary) {
            if (!part.matches("[0-9]+")) {
                throw IllegalArgumentExceptionType.ONLY_ACCOUNT_NUMBER_DIGIT.getException(); // 숫자가 아닌 문자가 포함되어 있음
            }
            totalLength += part.length();
        }

        char[] accountNumberLength = new char[totalLength];

        if (accountNumberLength.length != 14) {
            throw IllegalArgumentExceptionType.INVALID_ACCOUNT_NUMBER_LENGTH.getException();
        }
    }

    // 금액을 입력받고 검증하는 메서드
    public static double readAmount() {
        try {
            double amount = kb.nextDouble();

            // 금액이 유효한지 확인 -> 추후 validate로 빼기
            if (amount <= 0) {
                throw IllegalArgumentExceptionType.ONLY_AMOUNT_POSITIVE_NUMBER.getException();
            }

            return amount;

        } catch (IllegalArgumentException e) {
            System.out.println(IllegalArgumentExceptionType.INVALID_AMOUNT.getMessage());
            return readAmount();
        }
    }

    // 계좌 이체 정보 입력받는 메서드
    public static TransferDTO transferInput() {
        System.out.println("이체할 계좌번호를 입력하세요: ");
        String sourceAccountNumber = readAccountNumber();
        System.out.println("이체할 금액을 입력하세요: ");
        double amount = readAmount();
        System.out.println("상대방 계좌번호를 입력하세요: ");
        String destinationAccountNumber = readAccountNumber();

        return new TransferDTO(sourceAccountNumber, destinationAccountNumber, amount);
    }

    // 입금 정보 입력받는 메서드
    public static DepositDTO depositInput() {
        System.out.println("입금할 계좌번호를 입력하세요: ");
        String accountNumber = readAccountNumber();
        System.out.println("입금할 금액을 입력하세요: ");
        double amount = readAmount();

        return new DepositDTO(accountNumber, amount);
    }

    // 출금 정보 입력받는 메서드
    public static WithdrawDTO withdrawInput() {
        System.out.println("출금할 계좌번호를 입력하세요: ");
        String accountNumber = readAccountNumber();
        System.out.println("출금할 금액을 입력하세요: ");
        double amount = readAmount();

        return new WithdrawDTO(accountNumber, amount);
    }
}