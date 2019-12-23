package arraySorter;

/**
 * A tester for bubble sort.
 *
 * @param <T> the type of object in the arrays that this sorter sorts.
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public abstract class BubbleSortTest<T extends Comparable<? super T>> extends ArraySortTest<T> {
    @Override
    ArraySort<T> getSorter() {
        return new BubbleSort<T>();
    }
}

