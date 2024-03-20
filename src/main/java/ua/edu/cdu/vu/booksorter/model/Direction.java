package ua.edu.cdu.vu.booksorter.model;

import java.util.Comparator;

public enum Direction {
    ASC {
        @Override
        public <T> Comparator<T> apply(Comparator<T> comparator) {
            return comparator;
        }
    }, DESC {
        @Override
        public <T> Comparator<T> apply(Comparator<T> comparator) {
            return comparator.reversed();
        }
    };

    public abstract <T> Comparator<T> apply(Comparator<T> comparator);
}
