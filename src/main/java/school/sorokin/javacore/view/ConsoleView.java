package school.sorokin.javacore.view;

import school.sorokin.javacore.exceptions.NoAvailableCopiesException;
import school.sorokin.javacore.exceptions.NoSuchABookException;
import school.sorokin.javacore.store.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private static final int LIST_BOOKS_KEY = 1;
    private static final int GIVE_BOOK_KEY = 2;
    private static final int RETURN_BOOK_KEY = 3;
    private static final int ADD_NEW_BOOK_KEY = 4;
    private static final int EXIT_KEY = 5;

    private static final String INCORRECT_INPUT_MESSAGE = "Некорректный ввод! Повторите попытку.";
    private static final String AUTHOR_REQUEST = "Введите автора: ";
    private static final String TITLE_REQUEST = "Введите название: ";
    private static final String COUNT_REQUEST = "Введите количество: ";
    private static final String MENU_ITEM_REQUEST = "\n> ";
    
    private static final String LIST_BOOKS_WORD = "Вывести список книг";
    private static final String GIVE_BOOK_WORD = "Выдать книгу";
    private static final String RETURN_BOOK_WORD = "Вернуть книгу";
    private static final String ADD_NEW_BOOK_WORD = "Добавить новую книгу";
    private static final String EXIT_WORD = "Выход";

    private final Library lib = new Library();

    public void showMenu() {
        printMenuItem(LIST_BOOKS_KEY, LIST_BOOKS_WORD);
        printMenuItem(GIVE_BOOK_KEY, GIVE_BOOK_WORD);
        printMenuItem(RETURN_BOOK_KEY, RETURN_BOOK_WORD);
        printMenuItem(ADD_NEW_BOOK_KEY, ADD_NEW_BOOK_WORD);
        printMenuItem(EXIT_KEY, EXIT_WORD);
    }

    private static void printMenuItem(final int key, final String word) {
        System.out.printf("\n %d. %s. \n", key, word);
    }

    public void chooseMenuItem() {
        Scanner sc = new Scanner(System.in);

        switch (getInt(MENU_ITEM_REQUEST)) {
            case LIST_BOOKS_KEY:
                System.out.println("***\n" + lib.listBooks() + "***");
                break;

            case GIVE_BOOK_KEY:
                try {
                    final String title = getString(TITLE_REQUEST, sc);
                    final String author = getString(AUTHOR_REQUEST, sc);
                    lib.giveBook(title, author);
                } catch (NoSuchABookException | NoAvailableCopiesException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case RETURN_BOOK_KEY:
                try {
                    final String title = getString(TITLE_REQUEST, sc);
                    final String author = getString(AUTHOR_REQUEST, sc);
                    lib.returnBook(title, author);
                } catch (NoSuchABookException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case ADD_NEW_BOOK_KEY:
                    final String title = getString(TITLE_REQUEST, sc);
                    final String author = getString(AUTHOR_REQUEST, sc);
                    final int count = getInt(COUNT_REQUEST);
                    lib.addNewBooks(title, author, count);
                    break;

            case EXIT_KEY:
            System.exit(0);

            default:
                System.out.println(INCORRECT_INPUT_MESSAGE);
        }
    }

    private static String getString(final String request, final Scanner sc) {
        System.out.println(request);
        final String st = sc.next().trim();
        sc.nextLine();
        return st;
    }

    private static int getInt(final String request) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        boolean done = false;

        while (!done) {
            System.out.print(request);
            try {
                i = sc.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.println(INCORRECT_INPUT_MESSAGE);
                sc.nextLine();
            }
        }
        return i;
    }
}
