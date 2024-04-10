package sopt.bank;

import sopt.bank.controller.BankController;

public class Main {
    public static void main(String[] args) {
        BankController controller = new BankController();
        System.out.println("은행 계좌 관리 시스템에 오신 것을 환영합니다.");

        while (true) {
            controller.executeAction();
            System.out.println("계속하려면 아무 키나 누르세요. 종료하려면 q를 입력하세요.");
            String input = new java.util.Scanner(System.in).nextLine();
            if ("q".equalsIgnoreCase(input)) {
                break;
            }
        }

        System.out.println("프로그램이 종료되었습니다. 이용해 주셔서 감사합니다.");
    }
}