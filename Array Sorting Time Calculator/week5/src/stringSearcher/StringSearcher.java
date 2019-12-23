package stringSearcher;

/**
 * StringSearch essentially extends the functionality of a String
 * to search for that String in a superstring.
 *
 * Since the java String class is final we cannot extend it.  StringSearch
 * provides access to its String object with the string() method.
 *
 * Also, since indexing an array of chars is significantly faster than using
 * {@link String}'s charAt(int) method, the string, and its superstring are represented
 * by arrays of chars.
 *
 * @author Hugh Osborne
 * @version October 2019
 */

public abstract class StringSearcher {

    // This string searcher
    private char[] string;

    public StringSearcher(char[] string) {
        this.string = string;
    }

    public StringSearcher(String string) {
        this.string = string.toCharArray();
    }

    /**
     * Get this StringSearch's string.
     *
     * @return this StringSearch's String object
     */
    public char[] getString() {
        return string;
    }

   /**
     * Check for an occurrence of this StringSearch's string in a
     * superstring
     * @param superstring the superstring to be searched
     * @return the index of the leftmost occurrence of this StringSearch's
     * string in the superstring, if this exists
     * @throws NotFound if no such occurrence can be found
     */
    public abstract int occursIn(char[] superstring) throws NotFound;

    public int occursIn(String superstring) throws NotFound {
        return occursIn(superstring.toCharArray());
    }
}
