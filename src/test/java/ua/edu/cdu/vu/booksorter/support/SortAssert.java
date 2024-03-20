package ua.edu.cdu.vu.booksorter.support;

import org.opentest4j.AssertionFailedError;

import java.util.Comparator;
import java.util.List;

public class SortAssert {

    public static <T> void assertSorted(List<T> list, Comparator<T> comparator) {
        if (list.size() <= 1) {
            return;
        }
        var iterator = list.iterator();
        T previous = iterator.next();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (comparator.compare(previous, next) > 0) {
                throw new AssertionFailedError("List: %s is not sorted by provided comparator".formatted(list));
            }
            previous = next;
        }
    }
}
