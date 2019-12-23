package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import scope.IntegerScope;

/**
 * Tests bubble sort for integer arrays.
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public class IntegerBubbleSortTest extends BubbleSortTest<Integer> {
    @Override
    ArrayGenerator<Integer> getGenerator() {
        return new IntegerArrayGenerator(new IntegerScope());
    }
}
