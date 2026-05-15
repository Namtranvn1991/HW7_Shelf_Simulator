/**
 * Custom exception for shelf simulator domain errors.
 * Separates business logic errors (item doesn't fit, duplicate ID)
 * from programming errors (null pointer, etc.).
 */
public class ShelfSimulatorException extends Exception {

    public enum ErrorCode {
        ITEM_NOT_ON_SHELF
    }

    private final ErrorCode errorCode;

    public ShelfSimulatorException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
