package net.iizs.aor.model.exception;

public class NotAllowedByGameRuleException extends Exception {
    public NotAllowedByGameRuleException() {
        super();
    }

    public NotAllowedByGameRuleException(String message) {
        super(message);
    }

    public NotAllowedByGameRuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAllowedByGameRuleException(Throwable cause) {
        super(cause);
    }
}
