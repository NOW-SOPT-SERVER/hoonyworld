package sopt.bank.view.exception;

public interface ExceptionType<T> {
    String getMessage();

    T getException();
}
