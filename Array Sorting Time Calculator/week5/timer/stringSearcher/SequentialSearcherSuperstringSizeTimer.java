package stringSearcher;

import arrayGenerator.CharacterArrayGenerator;
import scope.CharacterScope;
import timer.Timer;

/**
 * Times the sequential searcher for varying sizes of superstring.  A fixed substring size (of 9) is used, and searched
 * for in superstrings of increasing size (from a minimum size of 10).
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public class SequentialSearcherSuperstringSizeTimer extends SequentialStringSearcher implements Timer {

    private static CharacterArrayGenerator generator = new CharacterArrayGenerator(new CharacterScope("abc"));

    public SequentialSearcherSuperstringSizeTimer(char[] string) {
        super(string);
    }

    private static char[] getString(int size) {
        Character[] tempArray = generator.getArray(size);
        char[] string = new char[size];
        for (int i = 0; i < size; i++) {
            string[i] = tempArray[i];
        }
        return string;
    }

    private static char[] superstring;

    private static char[] getSuperstring() {
        return superstring;
    }

    @Override
    public Timer getTimer(int size) {
        superstring = getString(size);
        char[] substring = getString(9);
        return new SequentialSearcherSuperstringSizeTimer(substring);
    }

    @Override
    public void timedMethod() {
        try {
            occursIn(getSuperstring());
        } catch (NotFound notFound) {

        }
    }

    @Override
    public long getMaximumRuntime() {
        return 5;
    }

    @Override
    public int getMinimumTaskSize() {
        return 10;
    }

    @Override
    public int getMaximumTaskSize() {
        return 20000000;
    }

    @Override
    public int getRunSetSize() {
        return 10;
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        //SequentialSearcherSuperstringSizeTimer timer = new SequentialSearcherSuperstringSizeTimer(null);
        //timer.timingSequence();
    	System.out.println("Cudina Paisi");
    	
    }
}
