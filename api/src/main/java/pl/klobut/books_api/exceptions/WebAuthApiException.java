package pl.klobut.books_api.exceptions;

public class WebAuthApiException extends Exception {

    private static final long serialVersionUID = -6223038311734208979L;

    private final WebApiExceptionType exceptionType;

    private final String detailMessage;

    public WebAuthApiException(WebApiExceptionType exceptionType) {
        this.exceptionType = exceptionType;
        this.detailMessage = "";
    }

    public WebAuthApiException(WebApiExceptionType exceptionType, String detailMessage) {
        this.exceptionType = exceptionType;
        this.detailMessage = detailMessage;
    }
}
