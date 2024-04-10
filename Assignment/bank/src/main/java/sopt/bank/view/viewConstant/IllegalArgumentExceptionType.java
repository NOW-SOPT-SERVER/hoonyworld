package sopt.bank.view.viewConstant;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {

    INVALID_MENU("[ERROR] 유효하지 않은 메뉴입니다."),
    INVALID_ACCOUNT_NUMBER("[ERROR] 유효하지 않은 계좌번호입니다."),
    INVALID_ACCOUNT_NUMBER_LENGTH("[ERROR] 계좌번호의 숫자는 14자리 입니다."),
    ONLY_ACCOUNT_NUMBER_DIGIT("[ERROR] 계좌번호는 숫자로 이루어져 있습니다."),
    INVALID_AMOUNT("[ERROR] 유효하지 않은 금액입니다."),
    ONLY_AMOUNT_POSITIVE_NUMBER("[ERROR] 금액은 양수여야 합니다."),
    INSUFFICIENT_BALANCE("[ERROR] 출금액이 잔액보다 큽니다.");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
