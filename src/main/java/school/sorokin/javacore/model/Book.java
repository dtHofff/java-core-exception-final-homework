package school.sorokin.javacore.model;

import school.sorokin.javacore.exceptions.NoAvailableCopiesException;

public class Book {

    private final String title;
    private final String author;
    private int availableCopies;

    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }


    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void increaseAvailableCopies(int newCopies) {
        this.availableCopies += newCopies;
    }

    public void decreaseAvailableCopies() throws NoAvailableCopiesException {
        if(this.availableCopies == 0) {
            throw new NoAvailableCopiesException();
        }
        this.availableCopies--;
    }

    public String getTitle() {
        return title;
    }

    public boolean isExist(final String title, final String author) {
        return (title.trim().equalsIgnoreCase(this.title) && author.trim().equalsIgnoreCase(this.author));
    }
}
