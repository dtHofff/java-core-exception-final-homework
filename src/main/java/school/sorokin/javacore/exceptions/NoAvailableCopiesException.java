package school.sorokin.javacore.exceptions;

public class NoAvailableCopiesException extends Exception {

    private static final String MESSAGE = "Нет доступных копий!";

    public NoAvailableCopiesException() {
        super(MESSAGE);
    }
}
