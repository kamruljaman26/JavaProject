package scope;

import java.util.Random;
import java.util.Set;

/**
 * Implements {@link scope.Scope}, when the set (or <i>alphabet</i>) of possible values is specified
 * by a {@link Set}.
 *
 * @param T the type of objects in the scope, and hence in the specifying set.
 *
 * @author Hugh Osborne
 * @version October 2019
 */

public class AlphabetScope<T> implements Scope<T> {

    // the alphabet (set of possible values) of this scope
    private Set<T> alphabet;

    private Random random = new Random();

    /**
     *
     * @param alphabet the alphabet of this scope.
     */
    public AlphabetScope(Set<T> alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Tests whether the given value is within the scope of this Scope.
     * I.e., is it in the alphabet of this scope.
     *
     * @param value the value to be checked.
     * @return true iff the value is within the scope of this Scope.
     */
    @Override
    public boolean contains(T value) {
        return alphabet.contains(value);
    }

    /**
     * Get a value within the scope of this Scope.
     *
     * @return a random value from this scope's alphabet.
     */
    @Override
    public T getValue() {
        return alphabet.stream()
                .skip(random.nextInt(alphabet.size()))
                .findFirst().get();
    }

    /**
     * How many values are there within this scope?
     *
     * @return the size of this scope's alphabet..
     */
    @Override
    public int size() {
        return alphabet.size();
    }
}
