package arrayGenerator;


import scope.Scope;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Implements additional tests, in addition to those inherited from {@link arrayGenerator.ArrayGeneratorTest}, to
 * check that:
 * <ul>
 *     <li> Values in generated arrays are within the specified scope</li>
 *     <li> All values in the scope are generated.  Note: this is a statistical test, and may produce a
 *          false fail.  See {@link #testCoversRange(Scope)} for details.</li>
 * </ul>
 *
 * @author Hugh Osborne
 * @version October 2019
 */

abstract class ScopedArrayGeneratorTest<T> extends ArrayGeneratorTest<T> {

    /**
     * Implementing classes must implement this method to return the sort of ScopedArrayGenerator the implementing class
     * is intended to test.
     *
     * @return a scoped array generator of the required type and specified scope.
     * @param scope the scope of the array generator to be tested.
     */
    abstract ScopedArrayGenerator<T> getGenerator(Scope<T> scope);

    /**
     * Check that the array contents are within the specified range.
     * @param scope the scope to be tested
     * @param size the size of the array
     */
    void testWithinRange(Scope<T> scope, int size) {
        ScopedArrayGenerator<T> generator = getGenerator(scope);
        T[] array = generator.getArray(size);
        for (T entry: array) {
            if (!scope.contains(entry)) {
                fail("Array entry is not within the expected bounds");
            }
        }
    }


    /**
     * When testing that a generated array contains all the values within the generator's scope,
     * only a statistical check can be carried out.  Since values are generated at random, there is
     * always a chance that a generated array, however large, may not contain all the values.
     *
     * However, the larger the generated array, the smaller this chance of a "false fail" is.
     *
     * ACCEPTABLE_FALSE_FAIL specifies the acceptable probability for such a false fail occuring.
     */
    private final static double ACCEPTABLE_FALSE_FAIL = 0.01;

    /**
     * Check that a generated array contains all the expected values.
     *
     * Note: since values are generated at random, there is always a chance that a
     * generated array may not contain all values within the range.
     *
     * The size of the generated array is set to
     *     1/c(n*H(n))
     * where
     * <ul>
     *    <li> <b>c</b>    is the probability that the array will not contain all values (i.e. the
     *                     chance of a "false fail") - so the {@link #ACCEPTABLE_FALSE_FAIL} above.</li>
     *    <li> <b>n</b>    is the number of values within the scope of this generator, and</li>
     *    <li> <b>H(n)</b> is the nth harmonic number (ie. 1/1 + 1/2 + ... + 1/n)</li>
     *  </ul>
     *  H(n), in turn is approximately n*ln(n) + gamma*n, where gamma is approximately
     *  0.5772156649.
     *  See <a href="https://en.wikipedia.org/wiki/Coupon_collector%27s_problem">https://en.wikipedia.org/wiki/Coupon_collector%27s_problem</a>.
     *
     * @param scope the scope to be tested.
     */
    void testCoversRange(Scope<T> scope) {
        double gamma = 0.5772156647;
        ScopedArrayGenerator<T> generator = getGenerator(scope);
        int testArraySize = (int)
            Math.ceil(
                    (1/ACCEPTABLE_FALSE_FAIL)*(scope.size()*Math.log(scope.size())+gamma*scope.size())
            );
        T[] array = generator.getArray(testArraySize);
        Set<T> seen = new HashSet<T>();
        for (T entry: array) {
            if (!seen.contains(entry)) {
                if (!scope.contains(entry)) {
                    fail("Array entry is not within expected bounds.");
                } else {
                    seen.add(entry);
                    if (seen.size() == scope.size()) {
                        break;
                    }
                }
            }
        }
        if (seen.size() < scope.size()) {
            fail("Array did not contain all expected values.\n"
                 + "Array is " + Arrays.toString(array) + "\n"
                 + "Scope is " + scope + "\n"
                 + "Saw " + seen +"\n"
                 + "Note: there is a " + ACCEPTABLE_FALSE_FAIL + " chance that this is a false fail.  See the method documentation for details.");
        }
    }
}