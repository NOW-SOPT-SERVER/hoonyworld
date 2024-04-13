package sopt.bank.controller;

import sopt.bank.domain.Account;
import sopt.bank.domain.Transaction;
import sopt.bank.view.InputView;
import sopt.bank.view.OutputView;
import sopt.bank.view.dto.DepositDTO;
import sopt.bank.view.dto.TransferDTO;
import sopt.bank.view.dto.WithdrawDTO;
import sopt.bank.view.exception.IllegalArgumentExceptionType;

import java.util.HashMap;
import java.util.Map;

public class BankController {

    private final Map<String, Account> accounts = new HashMap<>();

    public BankController() {
        accounts.put("1234567-8901234", new Account("1234567-8901234", "이동훈", 100000));
        accounts.put("2345678-9012345", new Account("2345678-9012345", "삼동훈", 100000));
    }

    public void executeAction() {
        try {
            int menu = InputView.readMenu();
            switch (menu) {
                case 1 -> {
                    TransferDTO transferDTO = InputView.transferInput();
                    transfer(transferDTO);
                }
                case 2 -> {
                    DepositDTO depositDTO = InputView.depositInput();
                    deposit(depositDTO);
                }
                case 3 -> {
                    WithdrawDTO withdrawDTO = InputView.withdrawInput();
                    withdraw(withdrawDTO);
                }
                default -> OutputView.printErrorMessage("잘못된 선택입니다. 다시 시도해주세요.");
            }
        } catch (Exception e) {
            OutputView.printErrorMessage("작업 수행 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private void transfer(TransferDTO input) {
        Account source = accounts.get(input.sourceAccountNumber());
        Account destination = accounts.get(input.destinationAccountNumber());
        if (source == null || destination == null) {
            OutputView.printErrorMessage("계좌 번호를 확인해주세요.");
            return;
        }
        Transaction transaction = new Transaction(input.amount());
        if (transaction.process(source, destination)) {
            OutputView.printTransactionConfirmation("계좌 이체", source, destination);
        } else {
            OutputView.printErrorMessage("계좌 이체 실패");
        }
    }

    private void deposit(DepositDTO input) {
        Account account = accounts.get(input.accountNumber());
        if (account == null) {
            OutputView.printErrorMessage("계좌 번호를 확인해주세요.");
            return;
        }
        account.deposit(input.amount());
        OutputView.printSuccessMessage("입금", input.amount());
        OutputView.printAccountBalance(account.getOwner(), account.getAccountNumber(), account.getBalance());
    }

    private void withdraw(WithdrawDTO input) {
        Account account = accounts.get(input.accountNumber());
        if (account == null) {
            OutputView.printErrorMessage("계좌 번호를 확인해주세요.");
            return;
        }
        try {
            account.withdraw(input.amount());
            OutputView.printSuccessMessage("출금", input.amount());
            OutputView.printAccountBalance(account.getOwner(), account.getAccountNumber(), account.getBalance());
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(IllegalArgumentExceptionType.INSUFFICIENT_BALANCE.getMessage())) {
                OutputView.printErrorMessage("잔액이 부족합니다.");
            } else {
                OutputView.printErrorMessage("출금 실패");
            }
        }
    }
}