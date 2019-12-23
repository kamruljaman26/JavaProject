package stringSearcher;

/**
 * Implements the simple sequential substring search algorithm
 *
 * @author Hugh Osborne
 * @version October 2019
 */

public class SequentialStringSearcher extends StringSearcher {
    public SequentialStringSearcher(char[] string) {
        super(string);
    }

    public SequentialStringSearcher(String string) {
        super(string);
    }

    /**
     * Does this string occur in the superstring?
     *
     * @param superstring the superstring to be searched
     * @return the index of the leftmost occurrence of this string in the superstring, if there is such an occurrence
     * @throws NotFound iff this string does not occur in the superstring
     */
    public int occursIn(char[] superstring) throws NotFound {
        /**
         * Perform a sequential search for this string in the superstring
         * for each index in the superstring {
         *   if this string occurs at that index {
         *     return the index
         *   }
         * }
         * no occurence found, so fail
         */
        for (int index = 0; index < superstring.length - getString().length; index++) {
            if (occursAt(superstring,index)) { // does this string occur at this index?
                return index; // yes, so return the index
            }
        }
        throw new NotFound(); // reached the end of the superstring without finding this string
    }

    /**
     * Try to match this string to the superstring at the given index.
     *
     * @param superstring the superstring we are looking in.
     * @param index the index at which to start looking
     * @return true iff the superstring segment starting at the given index matches this string
     */
    private boolean occursAt(char[] superstring,int index) {
        /**
         * Try to match the characters in this string, one by one, to the superstring.
         * for each character in the superstring, starting at the given index {
         *   if this character does not match the corresponding character in this string {
         *     mismatch - return false
         *   }
         * }
         * reached end of string without a mismatch - return true
         */
        for (int i = 0; i < getString().length; i++) {
            if (getString()[i] != superstring[i+index]) {
                return false;
            }
        }
        return true;
    }
}
