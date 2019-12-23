package arrayGenerator;

import org.junit.jupiter.api.Test;
import scope.IntegerScope;
import scope.Scope;

/**
 * Some basic tests for integer array generators, using {@link ScopedArrayGeneratorTest#testWithinRange(Scope, int)}.
 *
 * @author Hugh Osborne
 * @version October 2019.
 */
class IntegerArrayGeneratorTest extends ScopedArrayGeneratorTest<Integer> {

    /**
     * This class tests integer array generators.
     * @return an integer array generator with the default integer scope.
     */
    @Override
    ArrayGenerator<Integer> getGenerator()
    {
        return new IntegerArrayGenerator(new IntegerScope());
    }

    /**
     * This class tests integer array generators.
     * @return an integer array generator with the specified integer scope.
     */
    ScopedArrayGenerator<Integer> getGenerator(Scope<Integer> scope) {
        return new IntegerArrayGenerator(scope);
    }

    @Test
    void testInRangeThreeToEightySeven() {
        testWithinRange(new IntegerScope(3,87),150);
    }

    @Test
    void testInSingletonRangeFour()
    {
        testWithinRange(new IntegerScope(4,4),10);
    }

    @Test
    void testInSingletonRangeZero()
    {
        testWithinRange(new IntegerScope(0,0),150);
    }

    @Test
    void testCoversZeroToNine() {
        testCoversRange(new IntegerScope(0,9));
    }

    @Test
    void testCoversSingletonZero() {
        testCoversRange(new IntegerScope(0,0));
    }
}