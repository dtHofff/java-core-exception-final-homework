package school.sorokin.javacore.store;

import school.sorokin.javacore.exceptions.NoAvailableCopiesException;
import school.sorokin.javacore.exceptions.NoSuchABookException;
import school.sorokin.javacore.model.Book;

import java.util.ArrayList;

public class Library {

    private static final String SUCCESS_ADD_BOOK_MESSAGE = "Книги добавлены в каталог!";
    private static final String PIECES_WORD = "шт";
    private final ArrayList<Book> catalog;

    public Library() {
        this.catalog = new ArrayList<>();
    }

    // Добавляет указанное количество экземпляров книги или создает новую с указанным кол-вом экземпляров.
    public void addNewBooks(final String title, final String author, final int countOfCopies) {
        for (Book b: catalog) {
            if (b.isExist(title, author)) {
                b.increaseAvailableCopies(countOfCopies);
                return;
            }
        }
        catalog.add(new Book(title, author, countOfCopies));
        System.out.println(SUCCESS_ADD_BOOK_MESSAGE);
    }

    public void giveBook(final String title, final String author) throws NoAvailableCopiesException {
        for (Book b : catalog) {
            if (b.isExist(title, author)) {
                b.decreaseAvailableCopies();
                return;
            }
        }
        throw new NoSuchABookException();
    }

    public String listBooks() {
        StringBuilder list = new StringBuilder();
        int num = 1;
        for (Book book : catalog) {
            list.append(String.format("%d. %s. %s. %d %s. \n",
                    num, book.getAuthor(), book.getTitle(), book.getAvailableCopies(), PIECES_WORD));
            num++;
        }
        return list.toString();
    }

    public void returnBook(final String title, final String author){
        for (Book b: catalog) {
            if (b.isExist(title, author)) {
                b.increaseAvailableCopies(1);
                return;
            }
        }
        throw new NoSuchABookException();
    }
}



