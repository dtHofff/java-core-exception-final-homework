package school.sorokin.javacore.exceptions;

import java.util.NoSuchElementException;

public class NoSuchABookException extends NoSuchElementException {

    private static final String BOOK_DOES_NOT_EXIST_MESSAGE = "Книги нет в каталоге!";

    public NoSuchABookException() {
        super(BOOK_DOES_NOT_EXIST_MESSAGE);
    }
}
