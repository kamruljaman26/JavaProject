package arraySorter;

/**
 * The implementation of insertion sort from the lecture
 * 
 * @author kamruljaman
 * 
 * @param <T>
 */
public class InsertionSort<T extends Comparable<? super T>> implements ArraySort<T> {

	/**
	 * Sort an array.
	 * @param array the array to be sorted.
	 * @return the sorted array.
	 */
	@Override
	public T[] sort(T[] array) {
		/**
		 * Implements the sort using insertion sort: for j = 2 to n key ← A [j] //
		 * Insert A[j] into the sorted sequence A[1..j-1] j ← i – 1 while i > 0 and A[i]
		 * > key A[i+1] ← A[i] i ← i – 1 A[j+1] ← key
		 */
		int n = array.length; // Length of array
		for (int i = 1; i < n; i++) { // Loop start from 1 and running to n-1
			T key = array[i]; // Insert arry[j]/key into the sorted sequence A[1..j-1]
			int j = i - 1; // store right possition in j.

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && array[j].compareTo(key) > 0) {
				array[j+1] = array[j]; 
				j = j-1;
			}
			array[j+1] = key;
		}

		return array;
	}
}
