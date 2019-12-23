package arrayGenerator;


import scope.CharacterScope;
import scope.Scope;

/**
 * Class for generating random strings (arrays of Characters).  The strings will be constructed
 * from characters in the alphabet defined by this generator's scope.
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public class CharacterArrayGenerator extends ScopedArrayGenerator<Character>
{
  /**
     * Constructor where the alphabet is provided.
     *
     * @param scope the scope of the characters permitted for this generator.
     */
    public CharacterArrayGenerator(Scope<Character> scope)
    {
        super(scope);
    }

    /**
     * If no alphabet is provided, use the default alphabet provided by {@link CharacterScope}.
     */
    public CharacterArrayGenerator() {
        super(new CharacterScope());
    }

    /**
     * A createArray method is required for each non-generic class implementing the generic
     * {@link ScopedArrayGenerator} class with a specific type.  This is because we cannot
     * create generic arrays in Java (e.g. <tt>T[] array = <b>new</b> T[size]</tt>).
     * @param size the size of the array to be created
     * @return an array of {@link Character}s of the required size.  The values of the Characters
     *         will be uninstantiated.
     */
    @Override
    Character[] createArray(int size) {
        return new Character[size];
    }
}
