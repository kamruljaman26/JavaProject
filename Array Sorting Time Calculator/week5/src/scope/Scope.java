package scope;

/**
 * A scope represents a set of values - for example, an alphabet of characters, or a range of integers.
 *
 * @param <T> the type scoped by this Scope
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public interface Scope<T> {

    /**
     * Is the given value within the scope of this Scope?
     * 
     * @param value the value to be checked.
     * @return true iff the value is within the scope of this Scope.
     */
    public boolean contains(T value);

    /**
     * Get a value within the scope of this Scope.
     * 
     * @return a value within this scope.
     */
    public T getValue();

    /**
     * How many values are there within this scope?
     * 
     * @return the number of possible distinct values within this scope.
     */
    public int size();
}
