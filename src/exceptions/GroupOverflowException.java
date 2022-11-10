package exceptions;

public class GroupOverflowException extends Exception {
    @Override
    public String getMessage() {
        return "the group is overflown:  ";
    }
}
