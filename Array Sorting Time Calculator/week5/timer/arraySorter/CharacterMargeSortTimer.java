package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CharacterArrayGenerator;
import timer.Timer;

public class CharacterMargeSortTimer extends MargeSortTimer<Character> {
    /**
     * Timer 
     */
	@Override
    public Timer getTimer(int size) {
        ArrayGenerator<Character> generator = new CharacterArrayGenerator();
        setArray(generator.getArray(size));
        return this;
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        MargeSortTimer timer = new CharacterMargeSortTimer();
        timer.timingSequence();
    }
}