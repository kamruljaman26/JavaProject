package arraySorter;

import timer.Timer;

public abstract class InsertionSortTimer<T extends Comparable<? super T>> extends InsertionSort<T> implements Timer {

    private T[] array; // this is the array that will be sorted

    void setArray(T[] array) {
        this.array = array;
    }
    

	@Override
	public void timedMethod() {
		sort(array);
	}

	/**
	 * Set Time for bubble sort
	 */
	@Override
	public long getMaximumRuntime() {
		return 15;
	}

	@Override
	public int getMinimumTaskSize() {
		return 1;
	}

	@Override
	public int getMaximumTaskSize() {
		return 1000000000;
	}

	@Override
	public int getRunSetSize() {
		return 10;
	}

}
