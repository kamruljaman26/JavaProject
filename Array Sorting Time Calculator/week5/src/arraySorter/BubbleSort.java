package arraySorter;


/**
 * The implementation of bubble sort from the lecture
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public class BubbleSort<T extends Comparable<? super T>> implements ArraySort<T> {

    /**
     * Sort an array.
     *
     * @param array the array to be sorted.
     * @return the sorted array.
     */
    public T[] sort(T[] array) {
        /**
         * Implements the sort using bubble sort:
         * for (the whole list is unsorted;
         *      there is still part of the list unsorted;
         *      one more element has been sorted) {
         *    for (elements to be compared = first two elements;
         *         we haven't reached the end of the unsorted part;
         *         select the next pair of elements to be compared) {
         *       if (the first element > the second element) {
         *          swap them;
         *       }
         *    }
         * }
         */
        for (int lastUnsorted = array.length - 1;  // the whole list is unsorted
             lastUnsorted > 0; // stop when the whole list is sorted
             lastUnsorted--) { // one new element sorted each time round
            for (int nextToCompare = 0; // start comparing the first two elements
                 nextToCompare < lastUnsorted; // stop at the end of the unsorted portion
                 nextToCompare++) {
                if (array[nextToCompare].compareTo(array[nextToCompare + 1]) > 0) {
                    // the elements are in the wrong order so swap them around
                    T tmp = array[nextToCompare];
                    array[nextToCompare] = array[nextToCompare + 1];
                    array[nextToCompare + 1] = tmp;
                }
            }
        }
        return array;
    }
}
