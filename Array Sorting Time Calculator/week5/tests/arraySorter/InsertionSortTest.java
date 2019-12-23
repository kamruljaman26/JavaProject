package arraySorter;
/**
 * 
 * @author 
 *
 * @param <T> the type of object in the arrays that this sorter sorts.
 */
public abstract class InsertionSortTest <T extends Comparable<? super T>> extends ArraySortTest<T>{
    @Override
    ArraySort<T> getSorter() {
        return new InsertionSort<T>();
    }
}
