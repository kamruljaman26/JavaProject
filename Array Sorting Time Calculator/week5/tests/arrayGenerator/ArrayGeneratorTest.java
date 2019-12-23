package arrayGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Provides some basic tests for array generators:
 * <ul>
 *     <li> Do the generators generate arrays of the correct size?</li>
 *     <li> Do the generators throw the expected negative array size exception if asked to generate
 *          an array of negative size?</li>
 * </ul>
 *
 * @author Hugh Osborne
 * @version October 2019
 */

abstract class ArrayGeneratorTest<T> {

    /**
     * Implementing classes must implement this method to return the sort of ArrayGenerator the implementing class
     * is intended to test.
     * @return an array generator of the required type.
     */
    abstract ArrayGenerator<T> getGenerator();

    /**
     * Test that a generator does produce an array of the required length.
     *
     * @param size the length of the array that should be generated
     */
    private void testSize(int size) {
        ArrayGenerator generator = getGenerator();
        assertEquals(size,generator.getArray(size).length);
    }

    @Test
    void testZero() {
        testSize(0);
    }

    @Test
    void testOne() {
        testSize(1);
    }

    @Test
    void testTwo() {
        testSize(2);
    }

    @Test
    void testTwentyThree() {
        testSize(23);
    }

    @Test
    void testLarge() {
        testSize(3628751);
    }

    @Test
    void testMinusOne() {
        assertThrows(NegativeArraySizeException.class, ()->testSize(-1));
    }

    @Test
    void testMinusFiftyEight() {
        assertThrows(NegativeArraySizeException.class, ()->testSize(-58));
    }
}