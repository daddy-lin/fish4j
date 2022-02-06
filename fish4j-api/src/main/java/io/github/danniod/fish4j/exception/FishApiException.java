package io.github.danniod.fish4j.exception;

public class FishApiException extends Exception {

    private Integer code;

    public FishApiException(String message) {
        super(message);
    }

    public FishApiException(Integer code, String message) {
        this(message);
        this.code = code;
    }

    public FishApiException(Throwable e) {
        super(e);
    }

    public FishApiException(String message, Throwable e) {
        super(message, e);
    }
    public FishApiException(Integer code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }
}
