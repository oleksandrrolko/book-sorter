package ua.edu.cdu.vu.booksorter;

import ua.edu.cdu.vu.booksorter.domain.Book;
import ua.edu.cdu.vu.booksorter.model.Direction;

import java.util.*;
import java.util.function.Function;

public class BookSorter {

    private final List<Book> books = new ArrayList<>();

    public BookSorter add(Book... books) {
        this.books.addAll(Arrays.asList(books));
        return this;
    }

    public BookSorter addAll(Collection<Book> books) {
        this.books.addAll(books);
        return this;
    }

    public <T extends Comparable<T>> List<Book> sort(Function<Book, T> criteria, Direction direction) {
        var comparator = direction.apply(Comparator.comparing(criteria));
        return this.books.stream()
                .sorted(comparator)
                .toList();
    }

    public List<Book> sortByAuthor(Direction direction) {
        return sort(Book::author, direction);
    }

    public List<Book> sortByName(Direction direction) {
        return sort(Book::name, direction);
    }

    public List<Book> sortByYear(Direction direction) {
        return sort(Book::year, direction);
    }

    public List<Book> sortByPrice(Direction direction) {
        return sort(Book::price, direction);
    }
}
