package exceptions;

public class GroupOverflowException extends Exception {
    public GroupOverflowException() {
        super();
    }

    public GroupOverflowException(String message) {
        super(message);
    }
}
