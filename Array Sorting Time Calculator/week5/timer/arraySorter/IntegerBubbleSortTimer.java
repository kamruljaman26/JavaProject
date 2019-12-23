package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import scope.IntegerScope;
import timer.Timer;

/**
 * Time integer bubble sorters.
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public class IntegerBubbleSortTimer extends BubbleSortTimer<Integer> {
    @Override
    public Timer getTimer(int size) {
        ArrayGenerator<Integer> generator = new IntegerArrayGenerator(new IntegerScope());
        setArray(generator.getArray(size));
        return this;
    }

    public static void main(String[] args) {
        BubbleSortTimer timer = new IntegerBubbleSortTimer();
        timer.timingSequence();
    }
}
