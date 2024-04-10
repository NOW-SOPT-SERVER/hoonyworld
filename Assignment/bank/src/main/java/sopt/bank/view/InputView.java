package sopt.bank.view;

import sopt.bank.view.viewConstant.IllegalArgumentExceptionType;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    // 메뉴를 받고, 1~3 숫자 검증
    private static int readMenu() {
        try {
            Scanner kb = new Scanner(System.in);
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
    private static String readAccountNumber() {
        Scanner kb = new Scanner(System.in);
        String accountNumber = kb.next();
        validateAccountNumber(accountNumber);
        return accountNumber;
    }

    // 계좌번호 숫자인지 검증, 계좌번호 길이 검증(14자리)
    public static void validateAccountNumber(String accountNumber) {
        String[] temporary = accountNumber.split("-");
        int totalLength = 0;
        for (String part : temporary) {
            if (!part.matches("[0-9]+")) {
                throw IllegalArgumentExceptionType.INVALID_ACCOUNT_NUMBER.getException(); // 숫자가 아닌 문자가 포함되어 있음
            }
            totalLength += part.length();
        }

        char[] accountNumberLength = new char[totalLength];

        if (accountNumberLength.length != 14) {
            throw IllegalArgumentExceptionType.INVALID_ACCOUNT_NUMBER_LENGTH.getException();
        }
    }
}

/*
계좌 이체, 입금, 출금

계좌 이체를 진행하는 경우에는 콘솔창에 계좌 이체 를 입력하고
이체하고자 하는 상대방 계좌번호와 금액을 입력하여 이에 대한 상호작용을 구현하고
그 결과값(남은 금액)을 다시 콘솔창에 띄우는 방식으로 구현하면 됩니다.

 */