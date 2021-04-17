package pl.klobut.books_api.exceptions;

public enum WebApiExceptionType {
    USER_INACTIVE,
    MISSING_PASSWORD,
    USER_ACCOUNT_EXPIRED,
    BAD_PASSWORD,
    PASSWORD_EXPIRED,
    USER_NOT_FOUND,
    EMAIL_ALREADY_TAKEN
    ;
}
