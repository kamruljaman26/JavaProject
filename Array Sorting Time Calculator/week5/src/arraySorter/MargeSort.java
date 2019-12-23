package arraySorter;

public class MargeSort<T extends Comparable<? super T>> implements ArraySort<T> {
	/**
	 * Sort an array.
	 * 
	 * @param array the array to be sorted.
	 * @return the sorted array.
	 */
	@Override
	public T[] sort(T[] array) {
		sort(array,0,array.length-1);
		return array;
	}

	/**
	 * Main function that sorts arr[l..r] using
	 * merge()
	 * @param arr
	 * @param l
	 * @param r
	 */
	void sort(T arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;
			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/**
	 * Merges two subarrays of arr[].
	 * First subarray is arr[l..m]
	 * Second subarray is arr[m+1..r]
	 * @param arr
	 * @param l
	 * @param m
	 * @param r
	 */
	void merge(T arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		T L[] = (T[]) new Comparable[n1];
		T R[] = (T[]) new Comparable[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i].compareTo(R[j]) >= 0) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
