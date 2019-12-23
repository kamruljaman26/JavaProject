package scope;

import java.util.Random;

/**
 * Implements a scope of integers.  The scope is limited by a minimum and maximum value
 * (both included within the scope).
 *
 * @author Hugh Osborne
 * @version October 2019
 */

public class IntegerScope implements Scope<Integer> {
    private int minimum, maximum; // the limits within which values will be generated
    private Random random = new Random();

    /**
     * The most specific constructor.  Minimum and maximum are given explicitly.
     *
     * @param minimum the smallest value in this scope.
     * @param maximum the largest value in this scope.
     */
    public IntegerScope(int minimum, int maximum) {
        if (maximum < minimum) { // if maximum < minimum, swap them around
            int tmp = minimum;
            minimum = maximum;
            maximum = tmp;  // make sure minimum <= maximum
        }
        this.minimum = minimum;
        this.maximum = maximum;
    }

    /**
     * Only one value is given.  If this is less than zero, then it is the minimum
     * value in this scope (with zero as the maximum).  Otherwise, zero is the minimum,
     * and the value provided is the maximum.
     *
     * @param value the minimum or maximum value in this scope.
     */
    public IntegerScope(int value) {
        if (value <= 0) {
            minimum = value;
            maximum = 0;
        } else {
            minimum = 0;
            maximum = value;
        }
    }

    /**
     * No limits are given.
     */
    public IntegerScope() {
        minimum = 0;
        maximum = Integer.MAX_VALUE-1;
    }

    /**
     * Get a value within the scope of this Scope.
     *
     * @return a random element within this scope.
     */
    @Override
    public Integer getValue()
    {
        return minimum + random.nextInt(1+ maximum - minimum); // add 1 to make range inclusive
    }

    /**
     * Check whether a value is within the scope.
     *
     * @return true if the given value is between the minimum and the maximum (inclusive).
     */
    @Override
    public boolean contains(Integer value) {
        return minimum <= value && value <= maximum;
    }

    /**
     * How many values are there within this scope?
     *
     * Since the scope is inclusive of the maximum and minimum, the number of values in the
     * scope is one more than the difference between the maximum and minimum.
     *
     * @return the number of values in this scope.
     */
    @Override
    public int size() {
        return (maximum - minimum) + 1;
    }

    public String toString() {
        return minimum + " <-> " + maximum;
    }
}

