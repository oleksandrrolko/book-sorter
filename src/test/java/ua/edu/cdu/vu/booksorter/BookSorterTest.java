package ua.edu.cdu.vu.booksorter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.edu.cdu.vu.booksorter.domain.Book;
import ua.edu.cdu.vu.booksorter.model.Direction;

import java.util.Comparator;
import java.util.List;

import static ua.edu.cdu.vu.booksorter.support.SortAssert.assertSorted;

class BookSorterTest {

    private final BookSorter target = new BookSorter();

    @MethodSource("arguments")
    @ParameterizedTest
    void sortByAuthorAsc(List<Book> books) {
        target.addAll(books);
        var actual = target.sortByAuthor(Direction.ASC);
        assertSorted(actual, Comparator.comparing(Book::author));
    }

    @MethodSource("arguments")
    @ParameterizedTest
    void sortByNameAsc(List<Book> books) {
        target.addAll(books);
        var actual = target.sortByName(Direction.ASC);
        assertSorted(actual, Comparator.comparing(Book::name));
    }

    @MethodSource("arguments")
    @ParameterizedTest
    void sortByYearAsc(List<Book> books) {
        target.addAll(books);
        var actual = target.sortByYear(Direction.ASC);
        assertSorted(actual, Comparator.comparing(Book::year));
    }

    @MethodSource("arguments")
    @ParameterizedTest
    void sortByPriceAsc(List<Book> books) {
        target.addAll(books);
        var actual = target.sortByPrice(Direction.ASC);
        assertSorted(actual, Comparator.comparing(Book::price));
    }

    static Arguments[] arguments() {
        return new Arguments[] {
                Arguments.of(
                        List.of()
                ),
                Arguments.of(
                        List.of(new Book("Name", "Author", 2024, 50.0))
                ),
                Arguments.of(
                        List.of(
                                new Book("Book1", "Author1", 2000, 20.0),
                                new Book("Book3", "Author4", 2002, 10.0),
                                new Book("Book2", "Author3", 1992, 30.0),
                                new Book("Book4", "Author2", 2012, 50.0),
                                new Book("Book1", "Author2", 1992, 50.0)
                        )
                )
        };
    }
}
