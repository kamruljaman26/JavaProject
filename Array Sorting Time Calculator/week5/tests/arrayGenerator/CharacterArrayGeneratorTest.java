package arrayGenerator;

import org.junit.jupiter.api.Test;
import scope.CharacterScope;
import scope.Scope;

/**
 * Some basic tests for character array generators, using {@link ScopedArrayGeneratorTest#testWithinRange(Scope, int)}.
 *
 * @author Hugh Osborne
 * @version October 2019.
 */
class CharacterArrayGeneratorTest extends ScopedArrayGeneratorTest<Character> {

    /**
     * This class tests character array generators.
     * @return a character array generator with the default character scope.
     */
    @Override
    ArrayGenerator<Character> getGenerator() {
        return new CharacterArrayGenerator();
    }

    /**
     * This class tests character array generators.
     * @return a character array generator with the specified character scope.
     */
    @Override
    ScopedArrayGenerator<Character> getGenerator(Scope<Character> scope) {
        return new CharacterArrayGenerator(scope);
    }

    @Test
    void testInRangeABC() {
        testWithinRange(new CharacterScope("ABC"),150);
    }

    @Test
    void testInSingletonRangeZ()
    {
        testWithinRange(new CharacterScope("Z"),10);
    }

    @Test
    void testInAlphabet()
    {
        testWithinRange(new CharacterScope(),150);
    }

    @Test
    void testCoversAlphabet() {
        testCoversRange(new CharacterScope());
    }

    @Test
    void testCoversSingletonQ()
    {
        testCoversRange(new CharacterScope("Q"));
    }
}