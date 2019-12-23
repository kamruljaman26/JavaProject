package arrayGenerator;

import scope.Scope;

/**
 * Class for generating arrays of random Integers.  The values will be chosen
 * from within the range of the IntegerArrayGenerator object's minimum and
 * maximum fields (inclusive).
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public class IntegerArrayGenerator extends ScopedArrayGenerator<Integer>
{
    /**
     * @param scope the scope of values that may appear in the array.
     */
    public IntegerArrayGenerator(Scope<Integer> scope) {
        super(scope);
   }

    /**
     * If no integer scope is given, use the default scope provided by {@link scope.IntegerScope}.
     */
    /**
     * A createArray method is required for each non-generic class implementing the generic
     * {@link ScopedArrayGenerator} class with a specific type.  This is because we cannot
     * create generic arrays in Java (e.g. <tt>T[] array = <b>new</b> T[size]</tt>).
     * @param size the size of the array to be created
     * @return an array of {@link Integer}s of the required size.  The values of the Integers
     *         will be uninstantiated.
     */
    @Override
    Integer[] createArray(int size) {
        return new Integer[size];
    }
}
