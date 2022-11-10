package exceptions;

public class NoSuchStudentException extends Exception {
    @Override
    public String getMessage() {
        return "there is no such a student: ";
    }
}
